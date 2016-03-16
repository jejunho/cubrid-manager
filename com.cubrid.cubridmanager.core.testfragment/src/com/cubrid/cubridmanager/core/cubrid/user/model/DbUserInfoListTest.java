/*
 * Copyright (C) 2009 Search Solution Corporation. All rights reserved by Search Solution. 
 *
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met: 
 *
 * - Redistributions of source code must retain the above copyright notice, 
 *   this list of conditions and the following disclaimer. 
 *
 * - Redistributions in binary form must reproduce the above copyright notice, 
 *   this list of conditions and the following disclaimer in the documentation 
 *   and/or other materials provided with the distribution. 
 *
 * - Neither the name of the <ORGANIZATION> nor the names of its contributors 
 *   may be used to endorse or promote products derived from this software without 
 *   specific prior written permission. 
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, 
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, 
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY 
 * OF SUCH DAMAGE. 
 *
 */
package com.cubrid.cubridmanager.core.cubrid.user.model;

import junit.framework.TestCase;

/**
 * 
 * Test DbUserInfoList
 * 
 * @author sq
 * @version 1.0 - 2009-12-30 created by sq
 */
public class DbUserInfoListTest extends
		TestCase {
	private DbUserInfoList bean;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		bean = new DbUserInfoList();
		bean.setDbname("dbname");
		bean.removeUser(new DbUserInfo());
		bean.getUserList();
		bean.addUser(new DbUserInfo());
		assertEquals(bean.getUserList().size(), 1);
	}

	/**
	 * Test method for
	 * {@link com.cubrid.cubridmanager.core.cubrid.user.model.DbUserInfoList#getTaskName()}
	 * .
	 */
	public void testGetTaskName() {
		assertEquals(bean.getTaskName(), "userinfo");
	}

	/**
	 * Test method for
	 * {@link com.cubrid.cubridmanager.core.cubrid.user.model.DbUserInfoList#getDbname()}
	 * .
	 */
	public void testGetDbname() {
		assertEquals(bean.getDbname(), "dbname");
	}

	/**
	 * Test method for
	 * {@link com.cubrid.cubridmanager.core.cubrid.user.model.DbUserInfoList#getUserList()}
	 * .
	 */
	public void testGetUserList() {
		assertNotNull(bean.getUserList());
	}

	/**
	 * Test method for
	 * {@link com.cubrid.cubridmanager.core.cubrid.user.model.DbUserInfoList#addUser(com.cubrid.cubridmanager.core.cubrid.user.model.DbUserInfo)}
	 * .
	 */
	public void testAddUser() {
		bean.addUser(new DbUserInfo());
		assertFalse(bean.getUserList().isEmpty());

	}

	/**
	 * Test method for
	 * {@link com.cubrid.cubridmanager.core.cubrid.user.model.DbUserInfoList#removeUser(com.cubrid.cubridmanager.core.cubrid.user.model.DbUserInfo)}
	 * .
	 */
	public void testRemoveUser() {
		DbUserInfo dbUserInfo =new DbUserInfo(); 
		bean.addUser(dbUserInfo);
		assertTrue(bean.getUserList().contains(dbUserInfo));
	    bean.removeUser(dbUserInfo);
	    assertFalse(bean.getUserList().contains(dbUserInfo));
	}

	/**
	 * Test method for
	 * {@link com.cubrid.cubridmanager.core.cubrid.user.model.DbUserInfoList#getUserMap()}
	 * .
	 */
	public void testGetUserMap() {
		assertNotNull(bean.getUserMap());
		bean = new DbUserInfoList();	
		bean.getUserMap();
		bean.addUser(new DbUserInfo());
		bean.removeUser(new DbUserInfo());
		bean.getUserMap();
	}

}