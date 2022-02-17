import {Button, TextField} from "@mui/material"
import SaveIcon from "@material-ui/icons/Save"
function Capnhatbaiviet() {
    return(
        <div>
            <h1>Cập nhật bài viết</h1>
            <hr></hr>
            <p>Hình ảnh bài viết</p>
            <Button variant="contained" color="primary" >
                Thêm ảnh
            </Button><br />
            <div>
                
                <TextField 
                    variant="outlined"
                    color="primary"
                    label="Tên tác giả"
                /><br /><br />
                
                <TextField 
                    variant="outlined"
                    color="primary"
                    label="Tên bài viết"
                /><br />
                <label for="subject">Chủ đề</label><br />
                <select name="subject" id="subject">
                    <option></option>
                </select>
            </div>
            <div>
            <h2>Nội dung bài viết:</h2>
            <p>Nội dung ngắn:</p>
            <p>Nội dung bài viết:</p>
            </div>
        </div>
    )
}

export default Capnhatbaiviet;