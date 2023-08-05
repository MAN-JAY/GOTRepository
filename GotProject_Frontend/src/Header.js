import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';

const Header = () => {
  return (
    <>    <Box sx={{ flexGrow: 1 }}>
      <AppBar >
        <Toolbar >
          <IconButton >
            <MenuIcon />
          </IconButton>
          <Typography >
            Great House Of Westeros
          </Typography>
        </Toolbar>
      </AppBar>
    </Box>
    
</>

  );
}
export default Header;