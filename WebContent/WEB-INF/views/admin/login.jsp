<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../commonUser/header.jspf"%>
<%--content--%>

<div class="container">

    <div class="row">
        <div class="span6 offset3">
            <div class="page-header">
                <h1>Entrar</h1>
            </div>

            <form class="well form-horizontal" method="post" action="login.do">
                <fieldset>

                    <div class="control-group">
                        <label class="control-label" for="email">Email:</label>
                        <div class="controls">
                            <input id="email" name="email" type="email" class="input-medium" placeholder="your@email.com" required="required"/>
                            <p class="help-block alert-error"><c:out value="${requestScope.errorEmail}"/></p>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="password">Password:</label>
                        <div class="controls">
                            <input type="password" id="password" name="password" class="input-medium" placeholder="min 6 characters" required="required"/>
                            <p class="help-block alert-error"><c:out value="${requestScope.errorPassword}"/></p>
                        </div>
                    </div>

                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary"><i class="icon-lock icon-white"></i> Entrar</button>
                        <button type="button" class="btn" onclick="history.go(-1)"><i class="icon-remove"></i> Cancelar</button>
                    </div>


                </fieldset>
            </form>

        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../commonUser/footer.jspf"%>
