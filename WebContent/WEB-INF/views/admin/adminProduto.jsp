<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.connectedToys.bean.Produto"%>
<%@ include file="../commonAdmin/headerAdmin.jspf"%>
<div class="container">
    <div class="row">
        <div class="span3">
            <%@ include file="../commonAdmin/sidebarAdmin.jspf"%>
        </div>
     	<div class="span9" >
            <div class="well" align="center">
                
                
                <div class="page-header" >
                    <h1>Área Produto</h1>
                </div>
                
                <table class="table table-bordered table-striped table-todo" >
                
                                   
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Categoria</th>
                        <th>Faixa Etária</th>
                        <th>Preço</th>
                         <th>Ação</th>
                    </tr>
                  	 <tbody>
                   <%
					ArrayList<Produto> lista = new ArrayList<Produto>();
					lista = (ArrayList) request.getAttribute("produto");
					for (Produto produto : lista) {
					%>
					<tr>
						<td><%=produto.getId()%></td>
						<td><%=produto.getNome()%></td>
						<td><%=produto.getCategoria()%></td>
						<td><%=produto.getFaixaEtaria()%></td>
						<td>R$ <%=produto.getPreco()%></td>
						
							<td class="actions">
				  <a class="btn btn-mini btn-primary" href="updateProduto?id=<%=produto.getId()%>"><i class="icon-edit icon-white"></i> Editar</a>
				   			
				  <a class="btn btn-mini btn-danger" data-toggle="modal" href="#confirm_delete_<%=produto.getId()%>"><i class="icon-remove icon-white"></i> Deletar</a>
					
						 <div class="modal hide" id="confirm_delete_<%=produto.getId()%>">
						   <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">×</button>
	                                        <h3>Confirmação</h3>
	                                    </div>
	                                    <div class="modal-body">
	                                        <p>Tem certeza que deseja deletar o produto <%=produto.getId()%> : <%=produto.getNome()%> ?</p>
	                                    </div>
	                                    <div class="modal-footer">
	                                        <form action="deleteProduto.do" method="post">
	                                            <input type="hidden" name="id" value="<%=produto.getId()%>">
	                                            <a href="#" class="btn" data-dismiss="modal">Cancelar</a> <button  type="submit" class="btn btn-primary">Confirmar</button>
	                                        </form>
	                                    </div>
	                                </div>
				</td>	
				 
			</tr>			
					
					<%}%>
                   
                    </tbody>                        
                </table>     
                   <a href="newProduto" class="btn btn-primary"><i class="icon-ok icon-white"></i>Criar Produto</a>     
            </div>
        </div>
    </div>
</div>

<%@ include file="../commonAdmin/footerAdmin.jspf"%>
