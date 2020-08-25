
public class CustomExceptionsApp {

	// Consumer --> high level code
	public static void main(String[] args) {
	
		try {
			Cup myCup = new Cup(300.0);
			Cup yourCup = new Cup(-400.0);
			System.out.println(myCup);
			System.out.println(yourCup);
			
			if( myCup.getLiquidVolume() < yourCup.getLiquidVolume()) {
				System.out.println( "You have more drink!" );
			} else {
				System.out.println( " I have more drink!");
			}
			
		} catch (WrongVolumeValueException e) {
			
			//e.printStackTrace();
			System.out.println( "Wrong data, cannot work!" );
		}
		
		}

	}

////// provider --> low level code
class Cup {
	
	private Double liquidVolume;
	
	public Cup(Double liquidVolume) throws WrongVolumeValueException {
		this.setLiquidVolume(liquidVolume);
	}

	public Double getLiquidVolume() {
		return liquidVolume;
	}

	public void setLiquidVolume(Double liquidVolume) throws WrongVolumeValueException {
		if( liquidVolume >= 0) {
			this.liquidVolume = liquidVolume;
		} else {
			//System.out.println( "WRONG VOLUME VALUE!" );
			throw new WrongVolumeValueException( "Try to set negative volume" );
		}
		
	}

	@Override
	public String toString() {
		return "Cup [liquidVolume=" + liquidVolume + "]";
	}
	
}

class WrongVolumeValueException extends Exception {

	public WrongVolumeValueException(String message) {
		super(message);
		
	}
	
}











