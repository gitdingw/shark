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

import java.util.List;

import com.gxl.shark.sql.ast.SQLCommentHint;
import com.gxl.shark.sql.ast.SQLStatement;
import com.gxl.shark.sql.ast.SQLStatementImpl;
import com.gxl.shark.sql.visitor.SQLASTVisitor;

public class SQLExplainStatement extends SQLStatementImpl {

    protected SQLStatement       statement;

    private List<SQLCommentHint> hints;
    
    public SQLExplainStatement() {
        
    }
    
    public SQLExplainStatement(String dbType) {
        super (dbType);
    }

    public SQLStatement getStatement() {
        return statement;
    }

    public void setStatement(SQLStatement statement) {
        if (statement != null) {
            statement.setParent(this);
        }
        this.statement = statement;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, statement);
        }
        visitor.endVisit(this);
    }

    public List<SQLCommentHint> getHints() {
        return hints;
    }

    public void setHints(List<SQLCommentHint> hints) {
        this.hints = hints;
    }
}
