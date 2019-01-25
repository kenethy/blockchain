package blockchain;

import java.util.ArrayList;

/**
 * Reason book to insert blocks of transactions
 * 
 * @author Kenedy and Ikaro
 *
 */
public class Book {

	private ArrayList<Block> blockchain = new ArrayList<Block>();

	public ArrayList<Block> getBlockchain() {
		return blockchain;
	}

	public void setBlockchain(ArrayList<Block> blockchain) {
		this.blockchain = blockchain;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public Block transactionIndex(int index) {
		try {
			return this.getBlockchain().get(index);
		} catch (Exception e) {
			System.err.println("Index does not exist");
		}
		return null;
	}

	/**
	 * 
	 * @param source
	 * @return
	 */
	public ArrayList<Block> transactionSource(String source) {
		ArrayList<Block> blockSource = new ArrayList<Block>();
		for (Block block : blockchain) {
			if (block.data.getSource().equals(source))
				blockSource.add(block);
		}

		if (blockSource.isEmpty())
			return null;
		return blockSource;
	}
}
