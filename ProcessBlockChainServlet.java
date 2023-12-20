/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ProcessBlockChainServlet", urlPatterns = {"/ProcessBlockChainServlet"})
public class ProcessBlockChainServlet extends HttpServlet {
    static public List<Block> chain=new ArrayList<Block>();
    static private int i=0;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessBlockChainServlet</title>");            
            out.println("</head>");
            out.println("<body background=\"img/Product_Blockchain_1.png\">");
            out.println("<center><h1> BlockChain of Registered Products</h1></center>");
                     
            
             // Fetching Product Details..
            String productID = request.getParameter("pId");
            System.out.println(productID);
            String productName = request.getParameter("pName");
             System.out.println(productName);
            String companyDetails = request.getParameter("cDetails");
             System.out.println(companyDetails);
            String userDetails = request.getParameter("uDetails");
             System.out.println(userDetails);
            String addressDetails = request.getParameter("aDetails");
             System.out.println(addressDetails);
            
            String data=productID+productName+companyDetails+userDetails+addressDetails;
            
            
            Block newBlock=new Block("0x200",new java.util.Date(),data,"Adding"+i+
                    " Block in Blockchain for Registered Products..",i);
           
            
            String newBlockHash=newBlock.getHash();
            
            newBlockHash=newBlockHash.replace('+','s');           
           
            newBlock.setHash(newBlockHash);
            
          
            String QRCodeData="http://192.168.84.9:8080/DAV/ValidateProductServlet?hash="+newBlock.getHash();
           
            String QRCodeLocation="E:\\QRcodes\\"+productID+".png";
            
            try{
            CreateProductQRCode.generateQRcode(QRCodeData, QRCodeLocation);
            }catch(Exception e){
                System.out.println(e.toString());
            }
            
           if(chain.size()!=0)
            newBlock.setPreviousHash(chain.get(chain.size()-1).getHash());
            
            chain.add(newBlock);   
            
            out.println("*********************************************************************");
            for(int i=0;i<chain.size();i++){
               
                out.println("<br>");
                out.println("<b>Block "+i+"<br>");
                out.println("Version: "+chain.get(i).getVersion()+"<br>");
                out.println("Timestamp: "+chain.get(i).getTimestamp()+"<br>");
                out.println("Previous Block Hash: "+chain.get(i).getPreviousHash()+"<br>");
                out.println("Hash of Block "+i+" :"+chain.get(i).getHash()+"<br>");
                out.println("*********************************************************************");                  
           
            
        }           
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
