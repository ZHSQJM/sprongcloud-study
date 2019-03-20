package com.zhs.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @author Iron man
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class Dept implements Serializable{
	
	
   
   private static final long serialVersionUID = 1L;

   /**主键 */
   private Integer deptno;
   
   /**部门名称*/
   private String dname;
   
   /**来自哪个数据库 */
   private String db_source;

   public Dept(String dname) {
		super();
		this.dname = dname;
   } 
	   
   
	

}
