package model;
import java.io.Serializable;

public class User_info implements Serializable{
	//*************************************
	// メンバ変数の定義
	//*************************************
	private int id;
	private String name;
	private String sex;
	private String born;
	
	
	//*************************************
	// コンストラクタ
	//*************************************
	public User_info(int id, String name, String sex, String born){}
	
	public User_info(String name,String sex){
		this.name=name;
		this.sex=sex;
	}
	
	public User_info(int id,String name,String sex){
		this(name,sex);
		this.id=id;
		
	}
	
	//*************************************
	// メソッドの定義
	//*************************************
	// ゲッターとセッター
	
	// IDを取得
	public int getId() {
		return id;
	}
	
	// IDを設定
	public void setId(int id) {
		this.id = id;
	}
	
	// 名前を取得
	public String getName() {
		return name;
	}
	
	// 名前を設定
	public void setName(String name) {
		this.name = name;
	}
	
	// 値段を取得
	public String getSex() {
		return sex;
	}
	
	// 値段を設定
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	// 生年月日を取得
	public String getBorn() {
		return born;
	}
	
	// 生年月日を設定
	public void setBorn(String born) {
		this.born = born;
	}	


}
