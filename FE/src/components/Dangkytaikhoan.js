import * as Mui from "@mui/material"
import Text from "./Text"
// import Head from "./Head"

function Dangkytaikhoan() {
    return (
        <Mui.Container>
            {/* <Head /> */}
            <h2>Thông tin tài khoản</h2><br />
            <Mui.Grid
                justify="space-between"
                container
                spacing={2}
            >
                <Mui.Grid item md={6}>
                    <Text label="Tên người dùng" type="text" />
                </Mui.Grid>

                <Mui.Grid item md={6}>
                    <Text label="Tài khoản" type="text" />
                </Mui.Grid>

                <Mui.Grid item md={6}>
                    <Text label="Mật khẩu" type="password" />
                </Mui.Grid>

                <Mui.Grid item md={6}>
                    <Text label="Nhập lại mật khẩu" type="password" />
                </Mui.Grid>
                
                <Mui.Grid item md={6}>
                    <Mui.FormControl required fullWidth>
                        <Mui.InputLabel id="quyenhan">Quyền hạn</Mui.InputLabel>
                        <Mui.Select
                            labelId="quyenhan"
                            label="Quyền hạn"
                        >
                            <Mui.MenuItem value="admin">Admin</Mui.MenuItem>
                            <Mui.MenuItem value="Quản lý học viên">Quản lý học viên</Mui.MenuItem>
                            <Mui.MenuItem value="Cộng tác viên">Cộng tác viên</Mui.MenuItem>
                        </Mui.Select>
                    </Mui.FormControl>
                </Mui.Grid>
            </Mui.Grid>
            <Mui.Button variant="contained" color="primary">Lưu</Mui.Button>
            <Mui.Button variant="contained" color="secondary">Hủy</Mui.Button>
        </Mui.Container >
    )
}

export default Dangkytaikhoan