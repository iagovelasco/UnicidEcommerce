<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="WEB-INF/views/commonUser/header.jspf"%>
<%--content--%>

<div class="container">
    <div class="row">
        <div class="alert alert-block alert-error fade in">
            <h2 class="alert-heading">Usuário ou Senha não encontrado</h2>
            <br/>
            <div align="center">
                <p>
                    <a class="btn btn-danger" href="javascript:history.go(-1);">Voltar</a>
                </p>
            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="WEB-INF/views/commonUser/footer.jspf"%>