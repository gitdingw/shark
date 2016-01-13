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
package com.gxl.shark.sql.ast.expr;

import com.gxl.shark.sql.ast.SQLExprImpl;
import com.gxl.shark.sql.visitor.SQLASTVisitor;

public class SQLDefaultExpr extends SQLExprImpl implements SQLLiteralExpr {

    @Override
    public boolean equals(Object o) {
        return o instanceof SQLDefaultExpr;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
        visitor.endVisit(this);
    }

    public String toString() {
        return "DEFAULT";
    }
}
