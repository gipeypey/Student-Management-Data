
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static sun.security.jgss.GSSUtil.login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laode
 */
public class Admin extends javax.swing.JFrame {
    String gender;
    String program;
    public Admin() {
        initComponents();
        show_user();
        show_user1();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
    }
    public ArrayList<User> userList(){
        ArrayList<User> userList = new ArrayList<>();
        try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String url="jdbc:sqlserver://localhost:1433;databaseName=Login_Admin;user=sa;password=i8e6wu7i";
	Connection con = DriverManager.getConnection(url);
        String query1="SELECT * FROM mahasiswa";
        Statement st= con.createStatement();
        ResultSet rs= st.executeQuery(query1);
        User user;
        while(rs.next()){
            user=new User(rs.getInt("nim"), rs.getString("name"), rs.getString("address"), rs.getString("email"), rs.getString("phone"), rs.getString("gender"), rs.getString("classes"), rs.getString("major"));
            userList.add(user);
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return userList;
    }
    public void show_user(){
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel)data_table.getModel();
        Object[] row = new Object[8];
        for(int i=0;i<list.size();i++){
            row[0] = list.get(i).getnim();
            row[1] = list.get(i).getname();
            row[2] = list.get(i).getaddress();
            row[3] = list.get(i).getemail();
            row[4] = list.get(i).getphone();
            row[5] = list.get(i).getgender();
            row[6] = list.get(i).getclasses();
            row[7] = list.get(i).getmajor();
            model.addRow(row);

    }
        
    }
    
      public void show_user1(){
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel)data_table1.getModel();
        Object[] row = new Object[5];
        for(int i=0;i<list.size();i++){
            row[0] = list.get(i).getnim();
            row[1] = list.get(i).getname();
            row[2] = list.get(i).getgender();
            row[3] = list.get(i).getclasses();
            row[4] = list.get(i).getmajor();
            model.addRow(row);

    }
        
    }
    
    public void filternim(){
        try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String url="jdbc:sqlserver://localhost:1433;databaseName=Login_Admin;user=sa;password=i8e6wu7i";
	Connection con = DriverManager.getConnection(url);
        String sql = "Select * From mahasiswa WHERE nim =?";
        PreparedStatement pst = con.prepareStatement (sql);
        pst.setString(1,searchs.getText());
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            String setnim = rs.getString ("nim");
            nim.setText(setnim);
            String setname = rs.getString("name");
            name.setText(setname);
            String setadd = rs.getString("address");
            address.setText(setadd);
            String setemail = rs.getString("email");
            email.setText(setemail);
            String setphone = rs.getString("phone");
            phone.setText(setphone);
            String gen = rs.getString("gender");
            if(gen.equals("Male")){
                male.setSelected(true);
            }
            else{
                female.setSelected(true);
            }
            String classes1 = rs.getString("classes");
            switch(classes1){
                case "2SSC1":
                    classes.setSelectedIndex(0);
                    break;
                case "2SSC2":
                    classes.setSelectedIndex(1);
                    break;
                case "2SSC3":
                    classes.setSelectedIndex(2);
                    break;
                case "2SSC4":
                    classes.setSelectedIndex(3);
                    break;
                case "2SSC5":
                    classes.setSelectedIndex(4);
                    break;
                case "2NAP1":
                    classes.setSelectedIndex(5);
                    break;
                case "2NAP2":
                    classes.setSelectedIndex(6);
                    break;
                case "2NAP3":
                    classes.setSelectedIndex(7);
                    break;                  
                }
            
            String major1 = rs.getString("major");
            switch(major1){
                case "TI - AEU":
                    major.setSelectedIndex(0);
                    break;
                case "TI - PNJ":
                    major.setSelectedIndex(1);
                    break;
                case "TI - REGULER":
                    major.setSelectedIndex(2);
                    break;
                case "NAP - AEU":
                    major.setSelectedIndex(3);
                    break;
                case "NAP - PNJ":
                    major.setSelectedIndex(4);
                    break;
                case "NAP - REGULER":
                    major.setSelectedIndex(5);
                    break;
            }
           
        }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }    
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        category_programs = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        major = new javax.swing.JComboBox();
        exit = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        data_table = new javax.swing.JTable();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        classes = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        nim = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        searchs = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        data_table1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        src_group = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Name");

        jLabel3.setText("Address");

        jLabel4.setText("Email");

        jLabel5.setText("Phone");

        jLabel6.setText("Gender");

        category_programs.setText("Classes");

        jLabel8.setText("Major");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("STUDENT DATA");

        buttonGroup1.add(male);
        male.setText("Male");

        buttonGroup1.add(female);
        female.setText("Female");

        major.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TI - AEU", "TI - PNJ", "TI - REGULER", "NAP - AEU", "NAP - PNJ", "NAP - REGULER" }));

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        insert.setText("Save");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        data_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nim", "name", "address", "email", "phone", "gender", "classes", "major"
            }
        ));
        data_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(data_table);
        if (data_table.getColumnModel().getColumnCount() > 0) {
            data_table.getColumnModel().getColumn(2).setHeaderValue("address");
            data_table.getColumnModel().getColumn(3).setHeaderValue("email");
            data_table.getColumnModel().getColumn(4).setHeaderValue("phone");
        }

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        classes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2SSC1", "2SSC2", "2SSC3", "2SSC4", "2SSC5", "2NAP1", "2NAP2", "2NAP3", " " }));

        jLabel7.setText("Search Data by NIM ");

        jLabel10.setText("NIM");

        back.setText("Logout");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        searchs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchsActionPerformed(evt);
            }
        });
        searchs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchsKeyReleased(evt);
            }
        });

        data_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nim", "name", "gender", "classes", "major"
            }
        ));
        data_table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(data_table1);

        jLabel11.setText("Search by Shorting/Grouping");

        src_group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                src_groupActionPerformed(evt);
            }
        });
        src_group.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                src_groupKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jLabel12.setBackground(new java.awt.Color(153, 153, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Admin");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.NW_RESIZE_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));

        jLabel13.setBackground(new java.awt.Color(153, 153, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Copyright © 2020 LGR");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.NW_RESIZE_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(jLabel13))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(category_programs)
                            .addComponent(jLabel8)
                            .addComponent(btn_update))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(back))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(male)
                                .addGap(35, 35, 35)
                                .addComponent(female))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(classes, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(major, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(exit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(src_group, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchs, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(53, 53, 53))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(male)
                            .addComponent(female))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(category_programs)
                                    .addComponent(classes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(major, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_update)
                            .addComponent(btn_delete)
                            .addComponent(reset)
                            .addComponent(back))
                        .addGap(49, 49, 49)
                        .addComponent(exit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(searchs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(src_group, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String url="jdbc:sqlserver://localhost:1433;databaseName=Login_Admin;user=sa;password=i8e6wu7i";
	Connection con = DriverManager.getConnection(url);
        String query = "INSERT INTO mahasiswa(name, address, email, phone, gender, classes, major)values(?,?,?,?,?,?,?) "; 
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,name.getText());
        pst.setString(2, address.getText());
        pst.setString(3, email.getText());
        pst.setString(4, phone.getText());
        if(male.isSelected()){
            gender="Male";
        }
        if(female.isSelected()){
            gender="Female";
        }
        pst.setString(5, gender);
        String class1;
        class1=classes.getSelectedItem().toString();
        pst.setString(6, class1);
        
        String course;
        course=major.getSelectedItem().toString();
        pst.setString(7, course);
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)data_table.getModel();
        model.setRowCount(0);
        show_user();
        JOptionPane.showMessageDialog(null, "Inserted Data Successfully");
        DefaultTableModel model1 = (DefaultTableModel)data_table1.getModel();
        model1.setRowCount(0);
        show_user1();
        name.setText("");
        address.setText("");
        email.setText("");
        phone.setText("");
        buttonGroup1.clearSelection();
        classes.setSelectedIndex(0);
        major.setSelectedIndex(0);
     
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
    }//GEN-LAST:event_insertActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        name.setText("");
        address.setText("");
        email.setText("");
        phone.setText("");
        buttonGroup1.clearSelection();
        classes.setSelectedIndex(0);
        major.setSelectedIndex(0);
        nim.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void data_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_tableMouseClicked
        // TODO add your handling code here:
        int i = data_table.getSelectedRow();
        TableModel model = data_table.getModel();
        nim.setText(model.getValueAt(i,0).toString());
        name.setText(model.getValueAt(i,1).toString());
        address.setText(model.getValueAt(i,2).toString());
        email.setText(model.getValueAt(i,3).toString());
        phone.setText(model.getValueAt(i,4).toString());
        String gen = model.getValueAt(i,5).toString();
            if(gen.equals("Male")){
                male.setSelected(true);
            }
            else{
                female.setSelected(true);
            }
        String class1 = model.getValueAt(i,6).toString();
            switch(class1){
                case "2SSC1":
                    classes.setSelectedIndex(0);
                    break;
                case "2SSC2":
                    classes.setSelectedIndex(1);
                    break;
                case "2SSC3":
                    classes.setSelectedIndex(2);
                    break;
                case "2SSC4":
                    classes.setSelectedIndex(3);
                    break;
                case "2SSC5":
                    classes.setSelectedIndex(4);
                    break;
                case "2NAP1":
                    classes.setSelectedIndex(5);
                    break;
                case "2NAP2":
                    classes.setSelectedIndex(6);
                    break;
                case "2NAP3":
                    classes.setSelectedIndex(7);
                    break;
                
            }
        String major1 = model.getValueAt(i, 7).toString();
            switch(major1){
                case "TI - AEU":
                    major.setSelectedIndex(0);
                    break;
                case "TI - PNJ":
                    major.setSelectedIndex(1);
                    break;
                case "TI - REGULER":
                    major.setSelectedIndex(2);
                    break;
                case "NAP - AEU":
                    major.setSelectedIndex(3);
                    break;
                case "NAP - PNJ":
                    major.setSelectedIndex(4);
                    break;
                case "NAP - REGULER":
                    major.setSelectedIndex(5);
                    break;
            }
       
         
    }//GEN-LAST:event_data_tableMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String url="jdbc:sqlserver://localhost:1433;databaseName=Login_Admin;user=sa;password=i8e6wu7i";
	Connection con = DriverManager.getConnection(url);
        //int row = data_table.getSelectedRow();
        //String value = (data_table.getModel().getValueAt(row, 0).toString());
        String value = nim.getText();
        String query ="UPDATE mahasiswa SET name=?,address=?,email=?,phone=?,gender=?,classes=?,major=? WHERE nim="+value;
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,name.getText());
        pst.setString(2, address.getText());
        pst.setString(3, email.getText());
        pst.setString(4, phone.getText());
        if(male.isSelected()){
            gender="Male";
        }
        if(female.isSelected()){
            gender="Female";
        }
        pst.setString(5, gender);
        
        String class1;
        class1=classes.getSelectedItem().toString();
        pst.setString(6, class1);
        String course;
        course=major.getSelectedItem().toString();
        pst.setString(7, course);
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)data_table.getModel();
        model.setRowCount(0);
        show_user();
        JOptionPane.showMessageDialog(null, "Update Data Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        int Option = JOptionPane.showConfirmDialog(null, "Are You Sure to Delete Data", "Delete", JOptionPane.YES_NO_OPTION);
        if (Option==0){
        try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String url="jdbc:sqlserver://localhost:1433;databaseName=Login_Admin;user=sa;password=i8e6wu7i";
	Connection con = DriverManager.getConnection(url);
        int row = data_table.getSelectedRow();
        String value = (data_table.getModel().getValueAt(row,0).toString());
        String query = "DELETE FROM mahasiswa WHERE nim="+value;
        PreparedStatement pst = con.prepareStatement(query);
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)data_table.getModel();
        model.setRowCount(0);
        show_user();
        JOptionPane.showMessageDialog(null,"Delete Data Successfully");
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        Login field= new Login();
        field.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void searchsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchsKeyReleased
        // TODO add your handling code here:
       filternim();
       
        
    }//GEN-LAST:event_searchsKeyReleased

    private void searchsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchsActionPerformed

    private void data_table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_table1MouseClicked
        // TODO add your handling code here:
  
    }//GEN-LAST:event_data_table1MouseClicked

    private void src_groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_src_groupActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_src_groupActionPerformed

    private void src_groupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_src_groupKeyReleased
            String sql = "Select * From mahasiswa";
            DefaultTableModel laode = (DefaultTableModel)data_table1.getModel();
            String searching = src_group.getText().replaceAll(sql,sql);
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(laode);
            data_table1.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(searching));
            
    }//GEN-LAST:event_src_groupKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton back;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel category_programs;
    private javax.swing.JComboBox classes;
    private javax.swing.JTable data_table;
    private javax.swing.JTable data_table1;
    private javax.swing.JTextField email;
    private javax.swing.JButton exit;
    private javax.swing.JRadioButton female;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox major;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nim;
    private javax.swing.JTextField phone;
    private javax.swing.JButton reset;
    private javax.swing.JTextField searchs;
    private javax.swing.JTextField src_group;
    // End of variables declaration//GEN-END:variables
}
