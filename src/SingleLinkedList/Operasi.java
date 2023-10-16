package SingleLinkedList;

import java.util.Scanner;

public class Operasi {
	Node head;

	boolean isEmpty() {
		return (head == null);
	}
	
	void tambahDepan(int dataBaru) {
		Node tambahData = new Node(dataBaru);
		tambahData.data = dataBaru;
		tambahData.pointer = null;
		if (isEmpty()) {
			head = tambahData;
		} else {
			tambahData.pointer = head;
			head = tambahData;
		}
		System.out.println("Data telah ditambahkan");
	}
	
	void tambahTengah(int dataBaru, int posisi) {
		Node posNode = null;
		Node curNode = null;
		int i;
		Node newNode = new Node(dataBaru);
		if (head == null) {
			head = newNode;
		} else {
			curNode = head;
			if (posisi == 1) {
				newNode.pointer = curNode;
				head = newNode;
			} else {
				i = 1;
				while (curNode != null && i < posisi) {
					posNode = curNode;
					curNode = curNode.pointer;
					i++;
				}
				posNode.pointer = newNode;
				newNode.pointer = curNode;
			}
		}
		System.out.println("Data telah ditambahkan");
	}
	
	void tambahAkhir(int dataBaru) {
		Node tambahData = new Node(dataBaru);
		tambahData.data = dataBaru;
		tambahData.pointer = null;
		if (isEmpty()) {
			head = tambahData;
		} else {
			Node bantu = head;
			while (bantu.pointer != null) {
				bantu = bantu.pointer;
			}
			bantu.pointer = tambahData;
		}
		System.out.println("Data telah ditambahkan");
	}
	
	void hapusDepan() {
		if (isEmpty()) {
			System.out.println("Data masih kosong");
		} else {
			head = head.pointer;
		}
	}
	
	void hapusTengah(int data) {
		if (isEmpty()) {
			System.out.println("Data masih kosong");
		} else {
			Node preNode = null;
			Node delNode = null;
			int i;
			boolean ketemu;
			
			ketemu = false;
			i = 1;
			delNode = head;
			while (delNode.pointer != null && !(ketemu)) {
				if (delNode.data == data) {
					ketemu = true;
				} else {
					preNode = delNode;
					delNode = delNode.pointer;
					i++;
				}
			}
			
			if (ketemu == true) {
				if (i == 1) {
					head = null;
				} else {
					preNode.pointer = delNode.pointer;
				}
			}
		}
	}
	
	void hapusAkhir() {
		if (isEmpty()) {
			System.out.println("Data masih kosong");
		} else {
			Node preNode = null;
			Node curNode = null;
			if (head.pointer == null) {
				head = null;
			} else {
				curNode = head;
				while (curNode.pointer != null) {
					preNode = curNode;
					curNode = curNode.pointer;
				}
				preNode.pointer = null;
			}
		}
	}
	
	void tampilData() {
		Node posisi = head;
		if (isEmpty()) {
			System.out.println("Data masih kosong");
		} else {
			while (posisi != null) {
				System.out.print(posisi.data + ", ");
				posisi = posisi.pointer;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Operasi op = new Operasi();
		Scanner sc = new Scanner(System.in);
		
		int pilihan, input;
		
		System.out.println("Selamat Datang...");
		do {
			System.out.println("Daftar Menu");
			System.out.println("1. Tambah Depan");
			System.out.println("2. Tambah Tengah");
			System.out.println("3. Tambah Akhir");
			System.out.println("4. Hapus Depan");
			System.out.println("5. Hapus Tengah");
			System.out.println("6. Hapus Akhir");
			System.out.println("7. Tampil Data");
			System.out.println("8. Keluar");
			System.out.print("Menu pilihan anda: ");
			
			pilihan = sc.nextInt();	
			
			switch (pilihan) {
				case 1:
					System.out.print("Data : ");
					input = sc.nextInt();
					op.tambahDepan(input);
					break;
				case 2:
					System.out.print("Data : ");
					int inputNilai = sc.nextInt();
					System.out.print("Posisi : ");
					int inputPosisi = sc.nextInt();
					op.tambahTengah(inputNilai, inputPosisi);
					break;
				case 3:
					System.out.print("Data : ");
					input = sc.nextInt();
					op.tambahAkhir(input);
					break;
				case 4:
					op.hapusDepan();
					break;
				case 5:
					System.out.print("posisi : ");
					input = sc.nextInt();
					op.hapusTengah(input);
					break;
				case 6:
					op.hapusAkhir();
					break;
				case 7:
					op.tampilData();
					break;
				case 8:
					System.out.println("Anda telah keluar");
					break;
			}
		} while (pilihan != 8);
		sc.close();
	}	
}
