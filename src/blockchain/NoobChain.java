package blockchain;

import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class NoobChain {

	public static Book book = new Book();
	public static int difficulty = 6;

	public static void main(String[] args) {
		
		String blockchainJson;
		ArrayList<Block> blockchain = book.getBlockchain();
		
		/**
		 * TODO create insertion by the user
		 * while with additions by the user and finalization by choice
		 */
		
		/**
		 * Example test insert
		 */
		Data data = new Data("Kenedy", 1000, "Ikaro");
		blockchain.add(new Block(data, "0"));
		System.out.println("Trying to Mine block 1... ");
		blockchain.get(0).mineBlock(difficulty);
		
		/**
		 * Example test insert
		 */
		data = new Data("Ikaro", 10000, "Kenedy");
		blockchain.add(new Block(data, blockchain.get(blockchain.size() - 1).hash));
		System.out.println("Trying to Mine block 2... ");
		blockchain.get(1).mineBlock(difficulty);

		/**
		 * Json generation and print in screen
		 */
		blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(book.getBlockchain());
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
	}

	/**
	 * validation of the blockchain
	 * 
	 * @return
	 */
	public static Boolean isChainValid() {
		Block currentBlock;
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		ArrayList<Block> blockchain = book.getBlockchain();

		/**
		 * loop through blockchain to check hashes
		 */
		for (int i = 1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i - 1);
			/**
			 * comparison of the registered hash and calculated hash
			 */
			if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
				System.out.println("Current Hashes not equal");
				return false;
			}

			/**
			 * comparison previous hash and registered previous hash
			 */
			if (!previousBlock.hash.equals(currentBlock.previousHash)) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			/**
			 *  check if hash is solved
			 */
			if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		return true;
	}

}