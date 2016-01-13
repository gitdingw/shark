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
package com.gxl.shark.sql.ast.statement;

import java.util.Arrays;
import java.util.List;

import com.gxl.shark.sql.ast.SQLExpr;
import com.gxl.shark.sql.ast.SQLName;
import com.gxl.shark.sql.ast.SQLStatementImpl;
import com.gxl.shark.sql.ast.expr.SQLIdentifierExpr;
import com.gxl.shark.sql.visitor.SQLASTVisitor;

public class SQLDeleteStatement extends SQLStatementImpl {

	protected SQLTableSource tableSource;
	protected SQLExpr where;

	public SQLDeleteStatement() {

	}

	public SQLDeleteStatement(String dbType) {
		super(dbType);
	}

	public SQLTableSource getTableSource() {
		return tableSource;
	}

	public SQLExprTableSource getExprTableSource() {
		return (SQLExprTableSource) getTableSource();
	}

	public void setTableSource(SQLExpr expr) {
		this.setTableSource(new SQLExprTableSource(expr));
	}

	public void setTableSource(SQLTableSource tableSource) {
		if (tableSource != null) {
			tableSource.setParent(this);
		}
		this.tableSource = tableSource;
	}

	public SQLName getTableName() {
		return (SQLName) getExprTableSource().getExpr();
	}

	public void setTableName(SQLName tableName) {
		this.setTableSource(new SQLExprTableSource(tableName));
	}

	public void setTableName(String name) {
		setTableName(new SQLIdentifierExpr(name));
	}

	public SQLExpr getWhere() {
		return where;
	}

	/**
	 * 通过正则表达式拆分where后的数据
	 * 
	 * @author gaoxianglong
	 */
	public List<String> getWhere_() {
		return Arrays.asList(where.toString().split("\\s"));
	}

	public void setWhere(SQLExpr where) {
		if (where != null) {
			where.setParent(this);
		}
		this.where = where;
	}

	public String getAlias() {
		return this.tableSource.getAlias();
	}

	public void setAlias(String alias) {
		this.tableSource.setAlias(alias);
	}

	@Override
	protected void accept0(SQLASTVisitor visitor) {
		if (visitor.visit(this)) {
			acceptChild(visitor, tableSource);
			acceptChild(visitor, where);
		}

		visitor.endVisit(this);
	}

}
