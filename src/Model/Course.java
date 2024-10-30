package Model;

public class Course {
	public static final String MAHP = "NONE";
	public static final String TENHP = "NONE";
	public static final String KHOA = "NONE";
	public static final int SOTIN = 0;
	public static final String HOCKYCANHOC = "NONE";
	public static final int SOLOPMO = 0;

	private String MaHp;
	private String TenHp;
	private String Khoa;
	private int SoTin;
	private String HocKyCanHoc;
	private int SoLopMo;

	public Course() {
		this(Course.MAHP, Course.TENHP, Course.KHOA, Course.SOTIN, Course.HOCKYCANHOC, Course.SOLOPMO);
	}

	public Course(String MaHp, String TenHp, String Khoa, int SoTin, String HocKyCanHoc, int SoLopMo) {
		this.MaHp = MaHp;
		this.TenHp = TenHp;
		this.Khoa = Khoa;
		this.SoTin = SoTin;
		this.HocKyCanHoc = HocKyCanHoc;
		this.SoLopMo = SoLopMo;
	}

	public String getMaHp() {
		return MaHp;
	}

	public void setMaHp(String maHp) {
		MaHp = maHp;
	}

	public String getTenHp() {
		return TenHp;
	}

	public void setTenHp(String tenHp) {
		TenHp = tenHp;
	}

	public String getKhoa() {
		return Khoa;
	}

	public void setKhoa(String khoa) {
		Khoa = khoa;
	}

	public int getSoTin() {
		return SoTin;
	}

	public void setSoTin(int soTin) {
		SoTin = soTin;
	}

	public String getHocKyCanHoc() {
		return HocKyCanHoc;
	}

	public void setHocKyCanHoc(String hocKy) {
		HocKyCanHoc = hocKy;
	}

	public int getSoLopMo() {
		return SoLopMo;
	}

	public void setSoLopMo(int soLopMo) {
		SoLopMo = soLopMo;
	}

	@Override
	public String toString() {
		return "Course [MaHp=" + MaHp + ", TenHp=" + TenHp + ", Khoa=" + Khoa + ", SoTin=" + SoTin + ", HocKyCanHoc="
				+ HocKyCanHoc + ", SoLopMo=" + SoLopMo + "]";
	}

}
