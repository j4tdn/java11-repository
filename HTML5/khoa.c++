#include<iostream>
#include <string.h>
using namespace std;
class Vehicle{
	private:
		string maphuongtien;
		string tenphuongtien;
		int namsanxuat;
	    double giaban;
	public:
		Vehicle(){
			
		}
		
		Vehicle(string maphuongtien,string tenphuongtien, int namsanxuat, float giaban){
			this->maphuongtien=maphuongtien;
			this->tenphuongtien=tenphuongtien;
			this->namsanxuat=namsanxuat;
			this->giaban=giaban;
		}
		void nhap(){
			cout<<"\nNhap ma phuong tien:\t";
			cin>>this->maphuongtien;
			cout<<"\nNhap ten phuong tien:\t";
			cin>>this->tenphuongtien;
			cout<<"\nNhap nam san xuat:\t";
			cin>>this->namsanxuat;
			cout<<"\nNhap gia ban:\t";
			cin>>this->giaban;
			fflush(stdin);
		}
		string getmaphuongtien(){
			return maphuongtien;
		}
        void setmaphuongtien(int maphuongtien){
			this->maphuongtien=maphuongtien;
		}
		string gettenphuongtien(){
			return tenphuongtien;
		}
        void settenphuongtien(string tenphuongtien){
			this->tenphuongtien=tenphuongtien;
		}
		int getnamsanxuat(){
			return namsanxuat;
		}
        void setnamsanxuat(int namsanxuat){
			this->namsanxuat=namsanxuat;
		}
		float getgiaban(){            
	        return giaban;
        }
          void setgiaban(float giaban){
			this->giaban=giaban;
		}
		void xuat(){
			cout<<"\nMa phuong tien:\t"<<maphuongtien<<"\nTen phuong tien:\t"<<tenphuongtien<<"\nNam san xuat:\t"<<namsanxuat<<"\nGia ban:\t"<<giaban;
		}
		friend bool operator > (Vehicle A, Vehicle B){
			if(A.giaban > B.giaban) return true;
		else return false;
		}

};

class Car : public Vehicle {
public:
   private:
   int sochongoi;
   double dungdich;
   string loai_nhien_lieu;
   public:
    Car(){
			
	}
    Car(int sochongoi,double dungdich,string loai_nhien_lieu){
			this->sochongoi=sochongoi;
            this->dungdich=dungdich;
            this->loai_nhien_lieu=loai_nhien_lieu;

		}
    int getsochongoi(){
			return this->sochongoi;
		}
    void setsochongoi(int sochongoi){
			this->sochongoi=sochongoi;
		}
        double getdungdich(){
			return this->dungdich;
		}
    void setdungdich(double dungdich){
			this->dungdich=dungdich;
		}
        string getloai_nhien_lieu(){
			return this->loai_nhien_lieu;
		}
    void setloai_nhien_lieu(string loai_nhien_lieu){
			this->loai_nhien_lieu=loai_nhien_lieu;
		}
    void nhap(){
			cout<<"\nNhap so cho ngoi:\t";
			getline(cin,this->sochongoi);
			cout<<"\nNhap dung dich:\t";
			getline(cin,this->dungdich);
			cout<<"\nNhap loai nguyen lieu:\t";
			cin>>this->loai_nhien_lieu;
			
			fflush(stdin);
		}
};


int main(){
    Car c =Car();
    c.nhap();
	return 0;
}
