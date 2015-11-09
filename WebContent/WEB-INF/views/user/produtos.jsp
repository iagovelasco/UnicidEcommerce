<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.connectedToys.bean.Produto"%>
<%@ page import="br.com.connectedToys.dao.ProdutoDAO"%>
<%@ include file="../commonUser/header.jspf"%>
<div class="container">
    <div class="row" id="teste">
        <div class="span3">
            <%@ include file="../commonUser/sidebar.jspf"%>
        </div>
     	<div class="span10" >
            <div class="well" align="center">
                

           
                <div class="page-header" >
                    <h1>Produtos</h1>
                </div>
                 
           	 <ul class="thumbnails">
           	<%
           		ProdutoDAO produtoDAO;
           		produtoDAO = new ProdutoDAO();
           	
           		String nomeCat = request.getParameter("nome");
           		
           		List produto2 = produtoDAO.produtoCategoria(request.getParameter("nome"));
           		
           		ArrayList<Produto> listaProduto = new ArrayList<Produto>();
           		
           		listaProduto = (ArrayList) produto2;
           		for (Produto produto : listaProduto) {
           	
           	%>	
           	
	              
					<li class="span3">
						<div class="thumbnail">
							  <img src="<%= produto.getImagemUri() %>" alt="">
							<div class="caption">
								<h4><%=produto.getNome() %></h4>
								  <p><%=produto.getDescricao() %></p>
								  <h3>R$ <%=produto.getPreco() %></h3>
								<a class="btn btn-primary" data-toggle="modal"  href="#detalhe_produto_<%=produto.getId()%>">Detalhes</a>
									
									 <div class="modal hide"  id="detalhe_produto_<%=produto.getId()%>">
						   					<div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">×</button>
	                                        <h3>Detalhes</h3>
	                                    </div>
	                                    <div class="modal-body">
	                                   
	                                        <img class="img-200-200" src="<%= produto.getImagemUri() %>" alt="">
	                             				
													<div class="caption">
														<h5>Código: <%=produto.getId() %></h5> 
														<h5>Produto: <%=produto.getNome() %></h5>
												  		<h5>Preço:  R$ <%=produto.getPreco() %></h5>
												  		<h5>Categoria: <%=produto.getCategoria() %></h5>
												  		<h5>Descrição: <%=produto.getDescricao() %></h5>
												  
												  		</div>
												  		
													</div>
									
        
	                                    		<div class="modal-footer">
	                                       
	                                            
	                                            <a href="#" class="btn" data-dismiss="modal">Voltar</a>
	                                  
	                                    </div>
	                                </div>
								
								
								
								
								<a class="btn btn-success" data-toggle="modal"  href="#add_carrinho_<%=produto.getId()%>">Add to Cart</a>
								
								 <div class="modal hide"  id="add_carrinho_<%=produto.getId()%>">
						   					
	                                    <div class="modal-body">
	                                       <div class="alert alert-success">
											     
											      <h4>Adicionado!</h4>
											     O Produto <%=produto.getId()%>: <%=produto.getNome()%> foi adicionado ao carrinho!
											    </div>                                   
										</div>
                                		<div class="modal-footer">
	                                            <a href="#" class="btn" data-dismiss="modal">Voltar</a>
	                                    </div>
	                                </div>
								
								
								
								
							</div>
						</div>   
						</li>
		    <%}%> 
		    </ul>
		     
		   </div>
        </div>
    </div>
</div>


<%@ include file="../commonUser/footer.jspf"%>
