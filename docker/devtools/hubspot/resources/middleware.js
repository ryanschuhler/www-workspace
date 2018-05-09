module.exports = (req, res, next) => {

	if (req.method === 'POST') {
		res.status(204).send("")
	}
	else {
		next()
	}
  }