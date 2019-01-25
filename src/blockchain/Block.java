package blockchain;

import java.util.Date;

/**
 * Blockchain with all transaction information
 * 
 * @author Kenedy and Ikaro
 *
 */
public class Block {

	public String hash;
	public String previousHash;
	public Data data;
	private long timeStamp;
	private int nonce;

	// Block Constructor.
	/**
	 * create block, info add with data, previous hash, date transaction, hash
	 * transaction
	 * 
	 * @param data
	 * @param previousHash
	 */
	public Block(Data data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}

	/**
	 * calculate hash new block
	 * 
	 * @return new block hash
	 */
	public String calculateHash() {
		String calculatedhash = StringUtil
				.applySha256(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data);
		return calculatedhash;
	}

	/**
	 * include difficulty to determination and time of execution of the algorithm
	 * 
	 * @param difficulty
	 */
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0');
		while (!hash.substring(0, difficulty).equals(target)) {
			nonce++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}

}
