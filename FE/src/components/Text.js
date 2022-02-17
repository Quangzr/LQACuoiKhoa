import { TextField } from "@mui/material"

function Text(props) {
    return (
        <TextField
            variant="outlined"
            color="primary"
            label={props.label}
            type={props.type}
            required
            fullWidth
        />
    )
}

export default Text