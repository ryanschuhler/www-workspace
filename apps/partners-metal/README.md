# Partners Metal App

A Metal.js implementation of partners portlet

## Getting Started

From root partners directory:

1. Install npm dependences: `npm install`
2. Start webpack to bundle files: `npx webpack`
3. Deploy portlet `gradle deploy`

(Optional) To serve `bundle.js` without needing to redeploy, we can leverage `webpack-dev-server` to serve the files from a dev server

From root partners directory

1. Uncomment line in `view.jsp`.
2. Run `npx webpack-dev-server`. This will serve from `localhost:8081` (provided www-workspace is already using `localhost:80801)
