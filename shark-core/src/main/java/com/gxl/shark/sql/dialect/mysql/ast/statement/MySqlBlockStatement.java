/*
 * Copyright 1999-2101 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gxl.shark.sql.dialect.mysql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import com.gxl.shark.sql.ast.SQLStatement;
import com.gxl.shark.sql.dialect.mysql.visitor.MySqlASTVisitor;

public class MySqlBlockStatement  extends MySqlStatementImpl   {

	/**
	 * begin-end block label name 
	 * @author zz
	 */
	private String labelName;
	
	private List<SQLStatement>    statementList = new ArrayList<SQLStatement>();

    public List<SQLStatement> getStatementList() {
        return statementList;
    }

    public void setStatementList(List<SQLStatement> statementList) {
        this.statementList = statementList;
    }

    public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

    @Override
    public void accept0(MySqlASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, statementList);
        }
        visitor.endVisit(this);
    }

}
