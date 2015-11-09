<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.connectedToys.bean.Categoria"%>
<%@ page import="br.com.connectedToys.dao.CategoriaDAO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../commonAdmin/headerAdmin.jspf"%>


<div class="container">
    <div class="row">
        <div class="span6 offset3">
            <div class="page-header">
                <h1>Editar Produto</h1>
            </div>

            <form class="well form-horizontal" method="post" action="updateProduto.do">
            <jsp:useBean id="produto" scope="session"
							class="br.com.connectedToys.bean.Produto" />
            <fieldset>
            
               <div class="control-group">
                            <label class="control-label" for="name">Id Produto:</label>
                            <div class="controls">
                                <input type="text" id="id" name="id" value="<%=produto.getId()%>" />
                            </div>
                        </div>
                    
                        <div class="control-group">
                            <label class="control-label" for="name">Nome:</label>
                            <div class="controls">
                                <input type="text" id="name" name="name" required="required" autofocus="autofocus" value="<%=produto.getNome()%>"/>
                            </div>
                        </div>
                        
                        
                        
                        
                           <div class="control-group">
                            <label class="control-label" for="categoria">Categoria:</label>
                             <div class="controls">
                             <select class="selectpicker" name="categoria" id="categoria">
                                                
                        		<option  value="<%=produto.getCategoria()%>"><%=produto.getCategoria()%></option>
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
                              		<input readonly type="text" id="faixaEtaria" name="faixaEtaria" value="<%=produto.getFaixaEtaria()%>">
                            </div>
                        </div>
                        
                           <div class="control-group">
                            <label class="control-label" for="descricao">Descrição:</label>
                            <div class="controls">
                               <textarea class="form-control" rows="3" id="descricao" name="descricao">
                               	<%=produto.getDescricao() %>
                               </textarea>
                               
                            </div>
                        </div>
                        
                      
	 					
                        
                         <div class="control-group">
                            <label class="control-label" for="preco">Preço:</label>
                            <div class="controls">
                                <input type="text" id="preco" name="preco" class="dinheiro" required="required" value="<%=produto.getPreco()%>"/>
                            </div>
                        </div>

            

                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary"> <i class="icon-ok icon-white"></i> Editar</button>
                            <button type="button" class="btn" onclick="history.go(-1)"><i class="icon-remove"></i> Cancelar</button>
                        </div>

                    </fieldset>
                           
                
                    <script>                                      
                    	$("#id").prop("readonly", true); 
                    	
                    	
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
  


<%@ include file="../commonAdmin/footerAdmin.jspf"%>