package cn.netbuffer.dubbo.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "user")
@XmlRootElement
public class User implements Serializable {

	private static final long serialVersionUID = 4193866401992779318L;
	private Long id;
	@Size(min = 1, max = 20,message = "{username.valid}")
	private String name;
	private String sex;
	@NotNull(message = "年龄不为空")
	//引用国际化资源文件key为Range.user.age的信息,message = "{Range.user.age}"
	@Range(min = 1, max = 150)
//	@NumberFormat() 可以设置时间日期的格式化
	private Integer age;
	private String phone;
	private String deliveryaddress;
	private Integer adddate;
	private transient String comments;
	//jpa框架会维护version版本号字段 update ... where version=.. 当version字段被变更和之前读到的记录不符合，执行update就会出错
	private Integer version;

	@Transient
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getDeliveryaddress() {
		return deliveryaddress;
	}

	public void setDeliveryaddress(String deliveryaddress) {
		this.deliveryaddress = deliveryaddress == null ? null : deliveryaddress.trim();
	}

	public Integer getAdddate() {
		return adddate;
	}

	public void setAdddate(Integer adddate) {
		this.adddate = adddate;
	}

	public User(String name, String sex, Integer age, String phone, String deliveryaddress, Integer adddate,
				String comments) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.deliveryaddress = deliveryaddress;
		this.adddate = adddate;
		this.comments = comments;
	}

	public User(String name, String sex, Integer age, String phone, String deliveryaddress, Integer adddate,
				String comments,int version) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.deliveryaddress = deliveryaddress;
		this.adddate = adddate;
		this.comments = comments;
		this.version=version;
	}

	public User() {
	}
	
	public void init(){
		System.out.println("user init!");
	}
	
	public void syn(){
		synchronized(this){
			System.out.println("syn!");
			try {
				TimeUnit.SECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void syn2() {
		System.out.println("syn2!");
		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Transient
	public String getUserInfo(){
		return "用户名:"+this.name;
	}

	@Version
	@Column(name = "version")
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version=version;
	}

	@Override
	public String toString() {
		//允许打印transient成员
		return ToStringBuilder.reflectionToString(this,null,true);
	}

}