package main;

import packets.AddConnectionPacket;
import packets.RemoveConnectionPacket;
import packets.UpdatePosXPacket;


public class EventListener {
	
	public void received(Object p,Connection connection) {
		if(p instanceof UpdatePosXPacket){
			UpdatePosXPacket packet = (UpdatePosXPacket) p;
			packet.id = connection.id;
			for(int i=0; i<ConnectionHandler.connections.size(); i++) {
				Connection c = ConnectionHandler.connections.get(i);
				c.x = packet.x;
				if(c != connection) {
					c.sendObject(packet);
				}
			}
			System.out.println("received and sent an update X packet");}
		if(p instanceof AddConnectionPacket) {
			AddConnectionPacket packet = (AddConnectionPacket)p;
			packet.id = connection.id;
			for(int i=0; i<ConnectionHandler.connections.size(); i++) {
				Connection c = ConnectionHandler.connections.get(i);
				if(c != connection) {
					c.sendObject(packet);
				}
			}
			
		}else if(p instanceof RemoveConnectionPacket) {
			RemoveConnectionPacket packet = (RemoveConnectionPacket)p;
			System.out.println("Connection: " + packet.id + " has disconnected");
			ConnectionHandler.connections.get(packet.id).close();
			ConnectionHandler.connections.remove(packet.id);
		}
	}

}
