package test_dtodao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	// 데이터베이스 연동과 관련된 코드

	// 연동방법
//	1)클래스 로드 (프로그램 전체에서 1번만 하면 OK) - Static 초기화
//	2)DB연결 - Connection객체를 이용(메소드를 만듦)
//	연결되면 true, 안되면 false 
//	Connection변수 = DriverManager.getConnection(위치,아이디,비번)을 이용
//	*이작업을 해야 DB연결이 안됐을 때 다른 작업을 안할 수 있음

//	3)DB사용 - Statement, PreparedStatement, CallableStatement 객체 (SQL문 실행)
//	ResultSet - Select 구문 결과 출력 
//	
//	4)자원을 해제 - 3) 객체 3개 close();

	// 연결,사용,해제는 영역전체에서 사용될 가능성이 높음 => 전역변수로 만드는 것이 좋다.
	private Connection con;
	private Statement stmtI;
	private Statement stmtE;
	private ResultSet rs;
	private ResultSet rsE;
	// 위 세개의 변수는 서로 의존적으로 존재한다.
	// why? Connection 생성에 성공해야 그것을 가지고 Statement 객체를 생성가능
	// Statement객체가 Select 구문을 실행하는데 성공해야 ResultSet객체가 만들어진다.
	// =>따라서, Connection객체가 생성에 성공할 때만 이 작업을 연속해서 수행하는 것이 좋다.

	static {// static 초기화 작업
		// 이 내용들은 클래스가 메모리에 로드될 때 딱 한번만 수행됨.

		try {// 오라클 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("클래스 로드 실패 :" + e.getMessage());
		}
	}

	private DAO() {// Singleton클래스로 만들기 위한 과정--생성자를 private로 정의한다.

	}

	private static DAO obj;// 각각의 객체를 주소로 저장할 변수 선언

	public static DAO sharedInstance() {// 위에 선언한 static변수에 객체를 생성해주는 메서드
		if (obj == null) {
			obj = new DAO();
		}
		return obj;
	}

	// 데이터베이스 연결을 수행해주는 메소드
	private boolean connect() {
		boolean result = false;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결실패 : " + e.getMessage());
		}
		return result;
	}

//데이터베이스 연결을 해제하는 메소드
	private void close() {
		if (rs != null)
			try {
				rs.close();
				if (stmtI != null)
					stmtI.close();
				if (stmtE !=null)
					stmtE.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("해제 실패:" + e.getMessage());
			}

	}

	// 모든 테이블의 모든 데이터를 읽어서 List<Good> 타입에 저장해서 리턴하는 메소드
	// SQL 이용
	// Good는 DTO클래스의 Good
	public List<Good> getList() {
		// 데이터를 저장할 변수 선언
		List<Good> list = null;

		// 수행할 SQL문
		String sql = "SELECT * FROM goods";

		// 데이터베이스에 연결이 되었을 때만 Select문 실행
		if (connect()) {
			// 연결성공시
			try {
				// connection객체에 연결된 Statement객체를 생성하여 statement변수에 대입
				stmtI = con.createStatement();
				if ((stmtI != null)) {// sql문장을 받아와서 null이 아니다
					rs = stmtI.executeQuery(sql);// sql결과 저장
					
					// 데이터를 저장할 리스트 생성
					list = new ArrayList<Good>();

					// 데이터를 읽어서 list에 저장
					while (rs.next()) {
						Good goods = new Good();
						// DTO클래스에 변수값 세팅(Set메서드 이용)
						// select결과를 컬럼단위로 읽어오기(get변수타입(컬럼명)메소드 이용)

						goods.setCode(rs.getString("code"));
						goods.setName(rs.getString("name"));
						goods.setManufacture(rs.getString("manufacture"));
						goods.setPrice(rs.getInt("price"));
						goods.setMakingdate(rs.getDate("makingdate"));
						list.add(goods);
						
					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("데이터베이스 연결에 실패");
			System.exit(0);
		}
		return list;
	}

	
//	//수정하는 메서드
//	public boolean EditGood(Good good) {
//		boolean result = false;
//
//		if (this.connect()) {
//			String sql = "UPDATE goods SET NAME= ?, MANUFACTURE = ?, PRICE =?  WHERE CODE = cast(? as char(5))";//형변환
//			try {
//				PreparedStatement pstmt = con.prepareStatement(sql);// connection에서 수행한 sql을 가지고 pstmt객체 생성
//				// 바인딩 작업 : VALUES의 ?에 원래 들어갔어야 하는 원래 데이터 값을 입력
//				// HOW TO? set자료형(컬럼, 들어갈 데이터);
//				//여기서 숫자는 ?의 순서
//				pstmt.setString(1, good.getName());
//				pstmt.setString(2, good.getManufacture());
//				pstmt.setInt(3, good.getPrice());
//				pstmt.setString(4, good.getCode());
//
//				int r = pstmt.executeUpdate();
//
//				if (r > 0) {// 업데이트가 실행되면
//					result = true;
//				}
//				// 데이터베이스 생성 객체 해제
//				pstmt.close();
//				this.close();
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//				System.out.println(e.getMessage());// 예외가 발생한 원인 정보를 문자열의 형태로 반환
//				// 예외 클래스는 Throwable클래스를 상속, 여기에 getMessage가 정의 되어 있음
//			}
//		} else {
//			System.out.println("데이터베이스 연결실패");
//			System.exit(0);
//		}
//		return result;
//	}
	
	
	
	// (DB)Goods 테이블에 데이터를 삽입하는 메서드
	public boolean InsertGood(Good good) {
		boolean result = false;

		if (this.connect()) {
			String sql = "INSERT INTO goods Values(?,?,?,?,?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);// connection에서 수행한 sql을 가지고 pstmt객체 생성
				// 바인딩 작업 : VALUES의 ?에 원래 들어갔어야 하는 원래 데이터 값을 입력
				// HOW TO? set자료형(컬럼, 들어갈 데이터);
				pstmt.setString(1, good.getCode());// 인덱스는 DB기준이므로 1부터 시작
				pstmt.setString(2, good.getName());
				pstmt.setString(3, good.getManufacture());
				pstmt.setInt(4, good.getPrice());
				pstmt.setDate(5, good.getMakingdate());

				int r = pstmt.executeUpdate();

				if (r > 0) {// 업데이트가 실행되면
					result = true;
				}
				// 데이터베이스 생성 객체 해제
				pstmt.close();
				this.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());// 예외가 발생한 원인 정보를 문자열의 형태로 반환
				// 예외 클래스는 Throwable클래스를 상속, 여기에 getMessage가 정의 되어 있음
			}
		} else {
			System.out.println("데이터베이스 연결실패");
			System.exit(0);
		}
		return result;
	}
}
