<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../commonAdmin/headerAdmin.jspf"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.connectedToys.bean.Categoria"%>
<%@ page import="br.com.connectedToys.dao.CategoriaDAO"%>
<div class="container">
    <div class="row">
        <div class="span3">
            <%@ include file="../commonAdmin/sidebarAdmin.jspf"%>
        </div>
        <div class="span9">
            <div class="well">
           <br />
           
                <div class="page-header">
                    <h1>Criar Produto</h1>
                </div>

            <form class="well form-horizontal" method="post" action="newProduto" enctype="multipart/form-data">

                    <fieldset>
                        <div class="control-group">
                            <label class="control-label" for="title">Nome:</label>
                            <div class="controls">
                                <input type="text" id="name" name="name" required="required" autofocus="autofocus" />
                            </div>
                        </div>
                        
                         <div class="control-group">
                            <label class="control-label" for="categoria">Categoria:</label>
                             <div class="controls">
                             <select class="selectpicker" name="categoria" id="categoria">
                             <option>TODOS</option>
                        <%
                            ArrayList<Categoria> lista = (ArrayList<Categoria>) request.getAttribute("listaCategorias");
							for (Categoria categoria : lista  ) {	
						%>
                        		<option value="<%=categoria.getNome()%>"><%=categoria.getNome()%></option>
                        <%} %>         
                                </select>
                            </div>
                        </div>              
                        
                        <div class="control-group">
                            <label class="control-label" for="categoria">Faixa Etária:</label>
                             <div class="controls">
                        		<input readonly type="text" id="faixaEtaria" name="faixaEtaria" value="TODOS">
	                       </div>
                        </div>
                        
                         <div class="control-group">
                            <label class="control-label" for="descricao">Descrição:</label>
                            <div class="controls">
                               <textarea class="form-control" rows="3" id="descricao" name="descricao"></textarea>
                               
                            </div>
                        </div>
                      
	 			 	 <div class="control-group">
                            <label class="control-label" for="preco">Imagem:</label>
                            <div class="controls">
                              <input type="file" name="imagem" id="file" /> <br/>
							</div>
                        </div>
                        
                        <div class="control-group">
                            <label class="control-label" for="preco">Preço:</label>
                            <div class="controls">
                                <input type="text" id="preco" name="preco" class="dinheiro" required="required" />
                            </div>
                        </div>

                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary"> <i class="icon-ok icon-white"></i> Criar</button>
                            <button type="button" class="btn" onclick="history.go(-1)"><i class="icon-remove"></i> Cancelar</button>
                        </div>

                    </fieldset>

<script>

var menu_dropdown = document.getElementById("categoria");
		menu_dropdown.addEventListener("change", function(){
			$.ajax({
				  url: "/eCommerce/buscaFaixaEtaria.do",
				  context: document.body,
				  data: {nomeCategoria: $(this).val()},
				}).done(function(response) {
					$("#faixaEtaria").val(response);
				});	
		});
		
		
             $("input.dinheiro").maskMoney({showSymbol:true, symbol:"R$", decimal:",", thousands:"."});
      
</script>
				</form>

            </div>
        </div>
    </div>
</div>

<%@ include file="../commonAdmin/footerAdmin.jspf"%>
