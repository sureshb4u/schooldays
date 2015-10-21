package com.vernal.is.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vernal.is.dao.UserDAO;
import com.vernal.is.dto.ResponseBean;
import com.vernal.is.dto.UserAuthenticationDTO;
import com.vernal.is.dto.UserDTO;
import com.vernal.is.mapper.SessionMapper;
import com.vernal.is.mapper.UserListRowMapper;
import com.vernal.is.mapper.UserRowMapper;
import com.vernal.is.util.CommonConstants;

public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO{
	
	private static final String GET_USERS = "SELECT * FROM user";

	public static final Gson gson = new GsonBuilder().setDateFormat(CommonConstants.ISO_DATE_FORMAT).create();
	
    @Override
    public UserDTO aurthentication(UserAuthenticationDTO userAuthenticationDTO) {
    	UserDTO user = new UserDTO();
            try {
                if (userAuthenticationDTO != null) {
                    String sql = "SELECT ID_USER FROM user_authentication WHERE USER_NAME =?"
               + "AND USER_SECRET =?";
                    Object[] inputs = new Object[] {userAuthenticationDTO.getUserName(),userAuthenticationDTO.getUserSecret()};
                    Integer staffId =  getJdbcTemplate().queryForObject(
                            sql, inputs, Integer.class);
                    if (staffId!=null) {
                     String USER_INFO = "SELECT A.ID,A.FIRST_NAME,A.ID_ROLE,A.LAST_NAME,"
                     		+ "R.ID,R.ROLE,A.ID_GENDER,G.ID,G.GENDER,A.EMAIL_ADDRESS,A.ID_DESIGNATION,D.ID,D.DESIGNATION "
                     		+ "FROM USER A "
                     		+ "INNER JOIN USER_ROLE R ON A.ID_ROLE = R.ID"
                     		+ " INNER JOIN DESIGNATION D ON A.ID_DESIGNATION = D.ID "
                     		+ "INNER JOIN GENDER G ON A.ID_GENDER = G.ID "
                     		+ "WHERE A.ID = ?";
                         Object[] input = new Object[] {staffId};
                   	       user = getJdbcTemplate().queryForObject(USER_INFO, input, 
                			new SessionMapper());
                	
                    }
                }
            } catch (Exception ex) {
                logger.error("Exception in authentication -- " + ex);
               
            }
			return user;
    }

	@Override
	public List<UserDTO> getUsers() {
		List<UserDTO> userList = new ArrayList<UserDTO>();
		try {
			userList = getJdbcTemplate().query(GET_USERS, new UserListRowMapper());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return userList;
	}

	@Override
	public ResponseBean insertUser(UserDTO user,Integer accessId) {
		   ResponseBean responseBean = new ResponseBean();
		   String INSERT_USER = "INSERT INTO user(";
				   if(user.getRoles().getId()!= null){
					   INSERT_USER = INSERT_USER+ "`ID_ROLE`,";
		   		     }
				   if(user.getFirstName()!= null){
				   INSERT_USER = INSERT_USER+ " `FIRST_NAME`, ";
	               }
				   if(user.getLastName()!=null){
				   INSERT_USER = INSERT_USER+ "`LAST_NAME`, ";
				   }
				   if(user.getDateOfBirth()!=null){
				   INSERT_USER = INSERT_USER+ "`DATE_OF_BIRTH`, ";
				   }
				   if(user.getEmailAddresses()!=null){
				      INSERT_USER = INSERT_USER+ "`EMAIL_ADDRESS`, ";
				   }
				   if(user.getExperience()!=null){
					   INSERT_USER = INSERT_USER+ "`EXPERIENCE`, ";
					   }
				   if(user.getBioGraphy()!=null){
					   INSERT_USER = INSERT_USER+ "`BIO_GRAPHY`, ";
					   }
				   if(user.getDateOfJoining() !=null){
					   INSERT_USER = INSERT_USER+ "`DATE_OF_JOINING`, ";
					   }
				   if(user.getDesignation().getId() !=null){
					   INSERT_USER = INSERT_USER+ "`ID_DESIGNATION`, ";
					   }
				   if(user.getGender().getId()!= null){
				   INSERT_USER = INSERT_USER+ "`ID_GENDER`,";
				   }
				   if(user.getFatherName()!= null){
				   INSERT_USER = INSERT_USER+ "`FATHER_NAME`,";
				   }
				   if(user.getAge() != null){
				   INSERT_USER = INSERT_USER+ " `AGE`,";
				   }
				   if(user.getReligion().getId() != null){
				   INSERT_USER = INSERT_USER+ "`ID_RELIGON`,";
				   }
				   if(user.getCommunity().getId() != null){
				   INSERT_USER = INSERT_USER+ "`ID_COMMUNITY`,";
				   }
				   INSERT_USER = INSERT_USER+ "`IS_DELETED`,`CREATED_ON`,`CREATED_BY`)";
		   		
				   INSERT_USER = INSERT_USER+ " VALUES (";
				   if(user.getRoles().getId()!= null){
					   INSERT_USER = INSERT_USER+ user.getRoles().getId()+",";
		   		     }
				   if(user.getFirstName()!= null){
				   INSERT_USER = INSERT_USER+ user.getFirstName()+",";
	               }
				   if(user.getLastName()!=null){
				   INSERT_USER = INSERT_USER+user.getLastName()+",";
				   }
				   if(user.getDateOfBirth()!=null){
				   INSERT_USER = INSERT_USER+user.getDateOfBirth()+",";
				   }
				   if(user.getGender().getId()!= null){
				   INSERT_USER = INSERT_USER+ user.getGender().getId()+",";
				   }
				   if(user.getFatherName()!= null){
				   INSERT_USER = INSERT_USER+user.getFatherName()+",";
				   }
				   if(user.getAge() != null){
				   INSERT_USER = INSERT_USER+ user.getAge()+",";
				   }
				   if(user.getReligion().getId() != null){
				   INSERT_USER = INSERT_USER+user.getReligion().getId()+",";
				   }
				   if(user.getCommunity().getId() != null){
				   INSERT_USER = INSERT_USER+user.getCommunity().getId()+",";
				   }
				   INSERT_USER = INSERT_USER+"0,NOW(),";
				   INSERT_USER = INSERT_USER+ accessId;
				   INSERT_USER = INSERT_USER+ ")";
		   try{
			   KeyHolder keyHolder = new GeneratedKeyHolder();
			   SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
					   user);
			if(user != null)
			   getNamedParameterJdbcTemplate().update(INSERT_USER, namedParameters, keyHolder );
			Number id = keyHolder.getKey();
			System.out.println("id ------------>"+id);
			if(id != null){
				responseBean.setStatus("SUCCESS");
				responseBean.setMessage("The new user is added successfully");
			}else{
				
			}
		   }catch(Exception e){
			   responseBean.setStatus("FAILED");
			   String eStr = e.getMessage();
				responseBean.setMessage(eStr);
		   }
		
		return responseBean;
	}
  
	@Override
	public ResponseBean updateUser(UserDTO user, Integer accessId){
		ResponseBean responseBean= new ResponseBean();
		String UPDATE_USER = "UPDATE `user` SET ";
		   if(user.getRoles().getId()!= null){
			   UPDATE_USER = UPDATE_USER+ "`ID_ROLE`="+user.getRoles().getId()+",";
   		     }
		   if(user.getFirstName()!= null){
		   UPDATE_USER = UPDATE_USER+ " `FIRST_NAME`= "+ user.getFirstName()+",";
           }
		   if(user.getLastName()!=null){
		   UPDATE_USER = UPDATE_USER+ "`LAST_NAME`="+user.getLastName()+",";
		   }
		   if(user.getDateOfBirth()!=null){
		   UPDATE_USER = UPDATE_USER+ "`DATE_OF_BIRTH`="+user.getDateOfBirth()+",";
		   }
		   if(user.getEmailAddresses()!=null){
		      UPDATE_USER = UPDATE_USER+ "`EMAIL_ADDRESS`="+user.getEmailAddresses()+",";
		   }
		   if(user.getExperience()!=null){
			   UPDATE_USER = UPDATE_USER+ "`EXPERIENCE`="+user.getExperience()+",";
			   }
		   if(user.getBioGraphy()!=null){
			   UPDATE_USER = UPDATE_USER+ "`BIO_GRAPHY`="+user.getBioGraphy()+",";
			   }
		   if(user.getDateOfJoining() !=null){
			   UPDATE_USER = UPDATE_USER+ "`DATE_OF_JOINING`="+user.getDateOfJoining()+",";
			   }
		   if(user.getDesignation().getId() !=null){
			   UPDATE_USER = UPDATE_USER+ "`ID_DESIGNATION`"+user.getDesignation().getId()+",";
			   }
		   if(user.getGender().getId()!= null){
		   UPDATE_USER = UPDATE_USER+ "`ID_GENDER`"+user.getGender().getId();
		   }
		   if(user.getFatherName()!= null){
		   UPDATE_USER = UPDATE_USER+ "`FATHER_NAME`="+user.getFatherName();
		   }
		   if(user.getAge() != null){
		   UPDATE_USER = UPDATE_USER+ " `AGE`="+user.getAge();
		   }
		   if(user.getReligion().getId() != null){
		   UPDATE_USER = UPDATE_USER+ "`ID_RELIGON`="+user.getReligion().getId();
		   }
		   if(user.getCommunity().getId() != null){
		   UPDATE_USER = UPDATE_USER+ "`ID_COMMUNITY`="+user.getCommunity().getId();
		   }
		   UPDATE_USER = UPDATE_USER+ "`UPDATED_BY` ="+accessId;
		   UPDATE_USER = UPDATE_USER+ "WHERE ID="+user.getId();
		   UPDATE_USER = UPDATE_USER+ "AND IS_DELETED = 0";
		   try{
			   SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
					   user);
			if(user.getId() != null){
			   getNamedParameterJdbcTemplate().update(UPDATE_USER, namedParameters );
				responseBean.setStatus("SUCCESS");
				responseBean.setMessage("The new user is added successfully");
			}
		   }catch(Exception e){
			   responseBean.setStatus("FAILED");
			   String eStr = e.getMessage();
				responseBean.setMessage(eStr);
		   }
		   return responseBean;
	}
	


	public ResponseBean deleteUser(Integer userId,  Integer accessId) {
		ResponseBean responseBean = new ResponseBean();
		String DELETE_USER ="UPDATE `user` SET IS_DELETED = 1,UPDATED_BY ="+accessId +" WHERE USER ="+userId;
		   try{
			   SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
					   userId);
			if(userId != null){
			   getNamedParameterJdbcTemplate().update(DELETE_USER, namedParameters );
				responseBean.setStatus("SUCCESS");
				responseBean.setMessage("The user is deleted sccessfully");
			}
		   }catch(Exception e){
			   responseBean.setStatus("FAILED");
			   String eStr = e.getMessage();
				responseBean.setMessage(eStr);
		   }
		   return responseBean;
	}

	@Override
	public UserDTO getUser(Integer userId) {
		ResponseBean responseBean = new ResponseBean();
		String GET_USER = "SELECT * FROM USER A"
				+ " INNER JOIN USER_ROLE R ON A.ID_ROLE = R.ID "
				+ "INNER JOIN DESIGNATION D ON A.ID_DESIGNATION = D.ID "
				+ "INNER JOIN GENDER G ON A.ID_GENDER = G.ID "
				+ "INNER JOIN RELIGION REL ON A.ID_RELIGION = REL.ID "
				+ "INNER JOIN COMMUNITY C ON A.ID_COMMUNITY = C.ID"
				+ " WHERE A.ID= ? and A.IS_DELETED = 0";
		try{
		 Object inputs = new Object[] {userId};
		  UserDTO user =  getJdbcTemplate().queryForObject(
                  GET_USER, inputs,new UserRowMapper());
		return null;
		}
		catch (Exception e){
			 responseBean.setStatus("FAILED");
			   String eStr = e.getMessage();
				responseBean.setMessage(eStr);
		}
	}

}
