import com.esotericsoftware.kryonet.*;
public class Stickmanserver extends Listener {
    static Server server;
    static int udpPort = 27960, tcpPort=27960;
    public static void main(String[] args) throws Exception{
        server = new Server();
        server.getKryo().register(Packetsend.class);
        server.bind(tcpPort,udpPort);
        server.start();
        server.addListener(new Stickmanserver());
    }
    public void connected(Connection c){
        //Запрос к базе данных по смене значения 0 на 1.
    }
    public void received(Connection c,Object p){
        //проверка типа данных того,что мы получили и действие соответсвующих действий
    }
    public void disconnected(Connection c){
        // Запрос к базе данных о смене значения 1 на 0;
    }
}
