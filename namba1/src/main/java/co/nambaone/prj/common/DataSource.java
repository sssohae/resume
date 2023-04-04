package co.nambaone.prj.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource { // 싱글톤 class
	// 데이터 소스로부터 연결
	private static SqlSessionFactory sqlSessionFactory;
	private DataSource() {		// 내 클래스 명과 동일한 생성자를 외부에서 생성하지 못하도록 private로 만들어준다.
	};

	public static SqlSessionFactory getInstance() {
		String resource = "config/mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
}
	//데이터 소스를 요런 형태로 만들면 싱글톤으로 만들수있다. 가장 기본형태이다.
	//싱글톤은 인스턴스를 하나만 생성할수 있다. 그 하나를 다같이 이용하는거
	//싱글톤은 초기화 하지않고 불러서 쓸수있다.