package generic;

/*
 * 	Tạo cấu trúc dữ liệu JavaList
	Lưu trữ danh sách các phần tử (đối tượng)
	Phần tử có the là kiểu dạng số
	Dựa trên cấu trúc array, based index
	Có thể CRUD phần tử dễ dàng như Collection
 */
public interface IList<E> {
	int size();

	boolean isEmpty();

	boolean add(E e);

	E remove(int i);

	E get(int i);

	void set(int i, E e);
	
	void show();
	
	int count(Condition<E> condition);
	
	boolean remove(Object o);
}
