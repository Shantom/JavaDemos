import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

import java.sql.*;

public class MyDao {
    private Connection connection;
    public int id;
    public MyDao(int id){
        this.id = id;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                    "root", "123456");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void simpleQuery(){
        System.out.println("id query start: "+id);
        try(Statement s = connection.createStatement()) {
            s.executeQuery("select * from hero");
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        System.out.println("id query end: "+id);
    }

    public void list(int start, int count){
        try(PreparedStatement s = connection.prepareStatement("select * from hero limit ?,?")) {
            s.setInt(1, start);
            s.setInt(2, count);
            ResultSet rs = s.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void orm(int id){
        try(PreparedStatement s = connection.prepareStatement("select * from hero where id = ?")) {
            s.setInt(1, id);
            s.execute();
            ResultSet resultSet = s.getResultSet();
            while(resultSet.next()){
                Hero hero = new Hero();
                hero.id = id;
                hero.name = resultSet.getString("name");
                hero.damage = resultSet.getInt("damage");
                hero.hp = resultSet.getFloat("hp");
                System.out.println(hero);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    public void testCommit(){
        try(Statement s = connection.createStatement()) {
            connection.setAutoCommit(false);
            String sql1 = "update hero set hp = hp +1 where id = 1";
            s.execute(sql1);

            String sql2 = "update hero set hp = hp -1 where id = 1";
            s.execute(sql2);
            connection.commit();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

}
