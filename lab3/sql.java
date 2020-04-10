package com.huawei.classroom.student.lab3;

import java.util.List;

public class sql implements SqlUtil{

	 public String query(User user) {
		 if(user.getId()==-1 && user.getUsername() != "") {
			 return "SELECT * FROM `user` WHERE `username` LIKE '"+user.getUsername()+"'";
		 }
		 else if(user.getId() != -1 && user.getUsername() == "") {
			 return "SELECT * FROM user WHERE id = "+user.getId();
		 }
		 else if(user.getId() != -1 && user.getUsername() != "") {
			 return"SELECT * FROM `user` WHERE `username` LIKE '"+user.getUsername()+"',id ="+user.getId();
		 }
		 else
		     return null;
	 }

	@Override
	public String insert(User user) {
		// TODO Auto-generated method stub
	    String value = "('"+user.getUsername()+"','"+user.getTelephone()+"','"+user.getEmail()+"','"+user.getAge()+")";
		return "INSERT INTO `user` (`username`, `telephone`, `email`, `age`) VALUES" + value;
	}

	@Override
	public String insert(List<User> users) {
		// TODO Auto-generated method stub
		String output = "INSERT INTO `user` (`username`, `telephone`, `email`, `age`) VALUES";
		for(int i = 0;i < users.size();i++) {
			User user = users.get(i);
			String value = "";
			if(i == 0) {
				 value = "('"+user.getUsername()+"','"+user.getTelephone()+"','"+user.getEmail()+"','"+user.getAge()+")";
			}
			else
				 value = ",('"+user.getUsername()+"','"+user.getTelephone()+"','"+user.getEmail()+"','"+user.getAge()+")";
			output = output +value;
		}
		return output;
	}

	@Override
	public String delete(User user) {
		// TODO Auto-generated method stub
		if(user.getId() != -1) {
			 return "DELETE FROM user WHERE id = "+user.getId();
		 }
		return null;
	}

	@Override
	public String update(User user) {
		// TODO Auto-generated method stub
		if(user.getId() != -1) {
			if(user.getUsername()!="")
				return "UPDATE `user` SET `username` = '"+user.getUsername()+"' WHERE `id` = "+user.getId();
			else if(user.getTelephone()!="")
				return "UPDATE `user` SET `telephone` = '"+user.getTelephone()+"' WHERE `id` = "+user.getId();
			else if(user.getEmail()!="")
				return "UPDATE `user` SET `email` = '"+user.getEmail()+"' WHERE `id` = "+user.getId();
			else if(user.getAge()!=-1)
				return "UPDATE `user` SET `age` = '"+user.getAge()+"' WHERE `id` = "+user.getId();	
		}
		return null;
	}
	 	 
}
