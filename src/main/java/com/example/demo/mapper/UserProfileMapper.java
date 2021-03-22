package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.UserProfile;

@Mapper
public interface UserProfileMapper {
	@Select("SELECT * FROM UserProfile WHERE id=#{id}")
	UserProfile getUserProfile(@Param("id") String id);
	
	@Select("SELECT * FROM UserProfile")
	List<UserProfile> getUserProfileList();
	
	@Insert("INSERT INTO UserProfile(id, name, phonenum, addr) VALUES(#{id}, #{name}, #{phonenum}, #{addr})")
	int insertUserProfile(@Param("id")String id, @Param("name")String name, @Param("phonenum")String phonenum, @Param("addr")String addr);
	
	@Update("UPDATE UserProfile SET name=#{name} WHERE id=#{id}")
	int updateUserProfile(@Param("name") String name, @Param("id") String id);
	
	@Delete("DELETE FROM UserProfile WHERE id=#{id}")
	int deleteUserProfile(@Param("id") String id);
}
