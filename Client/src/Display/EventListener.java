package Display;

import packets.AddConnectionPacket;
import packets.RemoveConnectionPacket;
import packets.UpdatePosXPacket;

public class EventListener {
	
	public void received(Object p) {
		if(p instanceof AddConnectionPacket) {
			AddConnectionPacket packet = (AddConnectionPacket)p;
			ConnectionHandler.connections.put(packet.id,new Connection(packet.id,0));
			System.out.println(packet.id + " has connected");
		}else if(p instanceof RemoveConnectionPacket) {
			RemoveConnectionPacket packet = (RemoveConnectionPacket)p;
			System.out.println("Connection: " + packet.id + " has disconnected");
			ConnectionHandler.connections.remove(packet.id);
		}else if(p instanceof UpdatePosXPacket){
			UpdatePosXPacket packet = (UpdatePosXPacket) p;
			ConnectionHandler.connections.get(packet.id).x = packet.x;
		}
	}
}
