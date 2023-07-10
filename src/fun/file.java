package fun;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class file {

    /**
     * 文件复制
     *
     * @param srcPath  源文件
     * @param destPath 目标文件
     * @return boolean 是否成功
     */
    public static boolean filecopy(String srcPath,String destPath){

        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
               try{
                   bis=new BufferedInputStream(Files.newInputStream(Paths.get(srcPath)));
                   bos=new BufferedOutputStream(Files.newOutputStream(Paths.get(destPath)));
                   byte[] buff=new byte[1024];
                   int readLen=0;
                   while((readLen=bis.read(buff))!=-1){
                       bos.write(buff,0,readLen);
                   }
                   System.out.println("File has copied");
                   return true;
               }catch(IOException e){
                   e.printStackTrace();
               }finally {
                   try{
                       if(bis!=null){
                           bis.close();
                       }
                       if(bos!=null){
                           bos.close();
                       }
                   }
                   catch(IOException e){
                       e.printStackTrace();
                   }
               }
               return false;
    }

    /**
     * 显示文件选择窗口后复制
     *
     * @param destPath 目标路径
     * @return boolean 是否成功
     */
    public static boolean avatarcopy(String destPath){
        JFileChooser Chooser = new JFileChooser();
        Chooser.showOpenDialog(null);
        File f = Chooser.getSelectedFile();
        ImageIcon icon = new ImageIcon(f.getPath());
        boolean flag =false;
        String filename = f.getName();
        String filetype = filename.substring(filename.lastIndexOf("."));
//        if (filetype != "jpg") {
//            JOptionPane.showMessageDialog(null,"头像目前仅支持jpg格式");
//            return false;
//        }
        if (icon.getIconWidth()>120||icon.getIconHeight()>120){
            JOptionPane.showMessageDialog(null,"头像不能大于80像素");
        }else if(icon.getIconHeight()-icon.getIconWidth()>80) {
            JOptionPane.showMessageDialog(null, "头像请尽量上传正方形图片");
        }else {
            flag= filecopy(f.getPath(),destPath);
        }

        return flag;
    }
    public static boolean uploadbook(String destPath){
        JFileChooser Chooser = new JFileChooser();
        Chooser.showOpenDialog(null);
        File f = Chooser.getSelectedFile();
        ImageIcon icon = new ImageIcon(f.getPath());
        boolean flag =false;
        String filename = f.getName();
        String filetype = filename.substring(filename.lastIndexOf("."));
        if (icon.getIconWidth()>80||icon.getIconHeight()>110){
            JOptionPane.showMessageDialog(null,"图书封面的长宽需为70*100像素");
        } else {
            flag= filecopy(f.getPath(),destPath);
        }

        return flag;
    }

        public static boolean addHtml(String content,String username){
            //用于存储html字符串
            StringBuilder stringHtml = new StringBuilder();
            //输入HTML文件内容
            stringHtml.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
            stringHtml.append("<head>");
            //stringHtml.append("<meta http-equiv='Content-Type' content='text/html;  charset=UTF-8'>");
            stringHtml.append("<title>"+username+"的分享</title>");
            stringHtml.append("<link rel=\"stylesheet\" href=\"./share.css\">");
            stringHtml.append("</head>");
            stringHtml.append("<body>");
            stringHtml.append(content);
            stringHtml.append("</body></html>");
            try{
                JOptionPane.showMessageDialog(null,"保存文件命名必须为share");
                JFileChooser Chooser = new JFileChooser();
                Chooser.showOpenDialog(null);
                File file = Chooser.getSelectedFile();
                String htmlpath = file.getPath()+".html";
                String path = file.getPath();
                File f = new File(htmlpath);
                fun.file.filecopy("D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\style.css",path+".css");
                if (f.getParentFile() != null || !f.getParentFile().isDirectory()) {
                    // 创建文件
                    f.getParentFile().mkdirs();
                }
                //将HTML文件内容写入文件中

                FileOutputStream fileOutputStream=new FileOutputStream(htmlpath);
                PrintStream printStream=new PrintStream(fileOutputStream);
                // 转码，转化为utf-8
                String htmls = new String(stringHtml.toString().getBytes("utf-8"),"utf-8");
                printStream.println(htmls);
                fileOutputStream.flush();
                printStream.flush();
                fileOutputStream.close();
                printStream.close();
                return true;
            }catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

    }

