<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../commonAdmin/headerAdmin.jspf"%>
<%--content--%>

<div class="container">

    <div class="row">
        <div class="span6 offset3">
            <div class="page-header">
                <h1>Novo Administrador</h1>
            </div>

            <form class="well form-horizontal" method="post" action="newAdministrator">
           

                <fieldset>

                    <div class="control-group">
                        <label class="control-label" for="name">Nome:</label>
                        <div class="controls">
                            <input id="name" name="name" type="text" class="input-medium" required="required"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="email">Email:</label>
                        <div class="controls">
                            <input id="email" name="email" type="email" class="input-medium" placeholder="your@email.com" required="required"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="password">Senha:</label>
                        <div class="controls">
                            <input type="password" id="password" name="password" class="input-medium" placeholder="min 6 characters" required="required"/>
                           
                        </div>
                    </div>

                  <!--   <div class="control-group">
                        <label class="control-label" for="confirmationPassword">Confirmação de Senha:</label>
                        <div class="controls">
                            <input type="password" id="confirmationPassword" name="confirmationPassword" class="input-medium" placeholder="min 6 characters" required="required"/>
                            <p class="help-block alert-error"><c:out value="${requestScope.errorConfirmationPassword}"/></p>
                            <p class="help-block alert-error"><c:out value="${requestScope.errorConfirmationPasswordMatching}"/></p>
                        </div>
                    </div> -->

                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary"><i class="icon-lock icon-white"></i> Cadastrar</button>
                        <button type="button" class="btn" onclick="history.go(-1)"><i class="icon-remove"></i> Cancelar</button>
                    </div>

                </fieldset>
            </form>

        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../commonAdmin/footerAdmin.jspf"%>