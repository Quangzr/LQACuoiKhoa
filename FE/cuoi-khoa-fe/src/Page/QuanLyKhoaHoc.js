import Course from '../Table/Course'
import Sidebar from '../SideBar/SideBar'

function QuanLyKhoaHoc() {
    return(
        <div style={{display: 'flex'}}>
            <Sidebar />
            <div style={{marginTop: '60px'}}>
            Home - Quản lý khóa học
            <Course />
            </div>
            
        </div>
    ); 
}

export default QuanLyKhoaHoc