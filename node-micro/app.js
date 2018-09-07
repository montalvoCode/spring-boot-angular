const express = require('express')
const cors = require('cors')
const app = express()
 
app.use(cors())
const port = process.env.PORT || 3000

app.get('/message', (req, res) => {    
  res.end('Servicio creado en nodeJS')
})
 
app.listen(port,  () => {
  console.log(`API REST corriendo en  http://localhost:${port}`)
})