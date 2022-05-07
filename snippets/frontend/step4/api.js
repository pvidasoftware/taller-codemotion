const axios = require('axios');
const url = 'https://taller-codemotion-backend-XXXXX.cloud.okteto.net/api'

exports.handler = async (event) => {
    const request = JSON.parse(event.body)
    const config = {
      method: 'get',
      url: `${url}/${request.bignumber}`,      
    };
    try {
        const response = await axios(config)
        console.log(response.data)
        return {
          statusCode: 200,
          body: JSON.stringify(response.data)
        }
      } catch (error) {
        return {
          statusCode: 422,
          body: `Error: ${error}`
        }
    }      
}; 