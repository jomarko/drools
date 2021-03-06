/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.dmn.feel.lang.impl;

import org.kie.dmn.feel.codegen.feel11.CompiledFEELExpression;
import org.kie.dmn.feel.lang.EvaluationContext;
import org.kie.dmn.feel.lang.ast.ASTNode;
import org.kie.dmn.feel.lang.ast.FunctionDefNode;
import org.kie.dmn.model.api.GwtIncompatible;

@GwtIncompatible
public class InterpretedExecutableExpression implements CompiledFEELExpression {

    private final CompiledExpressionImpl expr;

    public InterpretedExecutableExpression(CompiledExpressionImpl expr) {
        this.expr = expr;
    }

    public boolean isFunctionDef() {
        return expr.getExpression() instanceof FunctionDefNode;
    }

    @Override
    public Object apply(EvaluationContext evaluationContext) {
        return expr.apply(evaluationContext);
    }

    /**
     * Internals helper methods.
     */
    public ASTNode getASTNode() {
        return expr.getExpression();
    }

}
