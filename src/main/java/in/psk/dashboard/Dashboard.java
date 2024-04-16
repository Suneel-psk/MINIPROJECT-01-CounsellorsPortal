package in.psk.dashboard;

public class Dashboard {
	private Long totalEnqs;
	private Long enrolledEnqs;
	private Long lostEnqs;
	private Long openEnqs;
	public Long getTotalEnqs() {
		return totalEnqs;
	}
	public void setTotalEnqs(Long totalEnqs) {
		this.totalEnqs = totalEnqs;
	}
	public Long getEnrolledEnqs() {
		return enrolledEnqs;
	}
	public void setEnrolledEnqs(Long enrolledEnqs) {
		this.enrolledEnqs = enrolledEnqs;
	}
	public Long getLostEnqs() {
		return lostEnqs;
	}
	public void setLostEnqs(Long lostEnqs) {
		this.lostEnqs = lostEnqs;
	}
	public Long getOpenEnqs() {
		return openEnqs;
	}
	public void setOpenEnqs(Long openEnqs) {
		this.openEnqs = openEnqs;
	}
	@Override
	public String toString() {
		return "Dashboard [totalEnqs=" + totalEnqs + ", enrolledEnqs=" + enrolledEnqs + ", lostEnqs=" + lostEnqs
				+ ", openEnqs=" + openEnqs + "]";
	}
	
}
