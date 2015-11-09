<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../commonAdmin/headerAdmin.jspf"%>


<div class="container">
    <div class="row">
        <div class="span6 offset3">
            <div class="page-header">
                <h1>Editar Categoria</h1>
            </div>

            <form class="well form-horizontal" method="post" action="updateCateg.do">
            <jsp:useBean id="categoria" scope="session"
							class="br.com.connectedToys.bean.Categoria" />
            <fieldset>
            
               <div class="control-group">
                            <label class="control-label" for="name">Id Categoria:</label>
                            <div class="controls">
                                <input type="text" id="id" name="id" value="<%=categoria.getId()%>" />
                            </div>
                        </div>
                    
                        <div class="control-group">
                            <label class="control-label" for="name">Nome:</label>
                            <div class="controls">
                                <input type="text" id="name" name="name" required="required" autofocus="autofocus" value="<%=categoria.getNome()%>"/>
                            </div>
                        </div>
                        
                         <div class="control-group">
                            <label class="control-label" for="linha">Gênero:</label>
                            	<div class="controls">
                            <select class="selectpicker" name="genero" id="genero" value="<%=categoria.getGenero()%>">
        							<option>Todos</option>
        							<option>Feminino</option>
        							<option>Masculino</option>
      						</select>
      						</div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="faixaEtaria">Faixa Etária:</label>
                            <div class="controls">
                             <select class="selectpicker" name="faixaEtaria" id="faixaEtaria" value="<%=categoria.getFaixaEtaria()%>">
        							<option>Todas</option>
        							<option>0 - 2 Anos</option>
        							<option>3 - 12 Anos</option>
        							<option>13 - 17 Anos</option>
        							<option>+18 Anos</option>
      						</select>
                            </div>
                        </div>

            

                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary"> <i class="icon-ok icon-white"></i> Editar</button>
                            <button type="button" class="btn" onclick="history.go(-1)"><i class="icon-remove"></i> Cancelar</button>
                        </div>

                    </fieldset>
                           
                
                    <script>                                      
                    	$("#id").prop("readonly", true);                    	
                     </script>
            </form>

        </div>
    </div> 
    </div> 


<%@ include file="../commonAdmin/footerAdmin.jspf"%>