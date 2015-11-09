<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../commonAdmin/headerAdmin.jspf"%>

<div class="container">
    <div class="row">
        <div class="span3">
            <%@ include file="../commonAdmin/sidebarAdmin.jspf"%>
        </div>
        <div class="span9">
            <div class="well">
           <br />
				
                <div class="page-header">
                    <h1>Criar Categoria</h1>
                </div>
				
		
				 <form class="well form-horizontal" method="post" action="newCategoria">

                    <fieldset>
                    
                        <div class="control-group">
                            <label class="control-label" for="name">Nome:</label>
                            <div class="controls">
                                <input type="text" id="name" name="name" required="required" autofocus="autofocus" />
                            </div>
                        </div>
                        
                         <div class="control-group">
                            <label class="control-label" for="linha">Gênero:</label>
                            	<div class="controls">
                            <select class="selectpicker" name="genero" id="genero">
        							<option>Todos</option>
        							<option>Feminino</option>
        							<option>Masculino</option>
      						</select>
      						</div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="faixaEtaria">Faixa Etária:</label>
                            <div class="controls">
                             <select class="selectpicker" name="faixaEtaria" id="faixaEtaria">
        							<option>Todas</option>
        							<option>0 - 2 Anos</option>
        							<option>3 - 12 Anos</option>
        							<option>13 - 17 Anos</option>
        							<option>+18 Anos</option>
      						</select>
                            </div>
                        </div>

            

                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary"> <i class="icon-ok icon-white"></i> Criar</button>
                            <button type="button" class="btn" onclick="history.go(-1)"><i class="icon-remove"></i> Cancelar</button>
                        </div>

                    </fieldset>

                </form>
                
                

            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../commonAdmin/footerAdmin.jspf"%>
