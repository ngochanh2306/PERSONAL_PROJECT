const express = require('express');
const router = express.Router();
const fdController = require('../controllers/fdController');
const checkLogin = require('../utils/checkLogin');
const cloudinary = require('../utils/cloudinary');
const upload = require('../utils/multer');

router.get('/', fdController.homepage);
router.get('/login', fdController.login);
router.post('/login', fdController.loginOnPost);
router.get('/register', fdController.register);
router.post('/register', fdController.registerOnPost);
router.get('/must-login', fdController.mustLogin);
router.get('/product/:id', fdController.product);

//Shipper router
router.get(
  '/shipper',
  checkLogin.checkLogin,
  checkLogin.checkShipper,
  fdController.shipper
);
router.get(
  '/staff-view-invoice/:id',
  checkLogin.checkLogin,
  checkLogin.checkShipper,
  fdController.staffViewInvoice
);
router.get(
  '/staff-view-delivering-invoice/:id',
  checkLogin.checkLogin,
  checkLogin.checkShipper,
  fdController.staffViewDeliveringInvoice
);
router.get(
  '/finish-dilivering/:id',
  checkLogin.checkLogin,
  checkLogin.checkShipper,
  fdController.staffFinishDilivering
);

//Admin router
router.get(
  '/admin-dashboard',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminDashboard
);
router.get(
  '/admin-drinks',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminDrinks
);
router.get(
  '/admin-foods',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminFoods
);

//food
router.get(
  '/admin-info',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminInfo
);
router.get(
  '/admin-add-food',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminAddFood
);
router.post(
  '/admin-add-food',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  upload.single('image'),
  fdController.adminAddFoodOnPost
);
router.get(
  '/admin-update-food/:id',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminUpdateFood
);
router.post(
  '/admin-update-food/:id',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  upload.single('image'),
  fdController.adminUpdateFoodOnPost
);
router.post(
  '/admin-delete-food/:id',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminDeleteFoodOnPost
);

//drink
router.get(
  '/admin-add-drink',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminAddDrink
);
router.post(
  '/admin-add-drink',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  upload.single('image'),
  fdController.adminAddDrinkOnPost
);
router.get(
  '/admin-update-drink/:id',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminUpdateDrink
);
router.post(
  '/admin-update-drink/:id',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  upload.single('image'),
  fdController.adminUpdateDrinkOnPost
);
router.post(
  '/admin-delete-drink/:id',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminDeleteDrinkOnPost
);
router.get(
  '/admin-show-staff-list',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminShowStaffList
);
router.get(
  '/admin-add-staff',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminAddStaff
);
router.post(
  '/admin-add-staff',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminAddStaffOnPost
);
router.get(
  '/admin-today-invoices',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminViewTodayInvoices
);
router.get(
  '/admin-all-invoices',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminViewAllInvoices
);
router.get(
  '/admin-ordered-invoices',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminViewOrderedInvoices
);
router.get(
  '/admin-confirmed-invoices',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminViewConfirmedInvoices
);
router.get(
  '/admin-got-invoices',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminViewGotItemsInvoices
);
router.get(
  '/admin-done-invoices',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminViewDoneInvoices
);
router.get(
  '/admin-canceled-invoices',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminViewCanceledInvoices
);
router.get(
  '/admin-view-invoice/:id',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminViewInvoice
);
router.get(
  '/admin-delete-canceled-invoices',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminDeleteCanceledInvoice
);
router.post(
  '/admin-arrange-staff/:id',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminArangeStaffOnPost
);
router.get(
  '/admin-confirm-invoice/:id',
  checkLogin.checkLogin,
  checkLogin.checkAdmin,
  fdController.adminConfirmInvoice
);

//Client router
router.get(
  '/client',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.client
);
router.get(
  '/info',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.clientInfo
);
router.get(
  '/client-product/:id',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.clientProduct
);
router.get(
  '/cart',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.clientCart
);
router.get(
  '/foods',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.clientFoods
);
router.get(
  '/drinks',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.clientDrinks
);
router.get(
  '/all',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.clientAllProduct
);
router.post(
  '/search',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.searchRecipe
);
router.post(
  '/add-cart/:id',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.addCartOnPost
);
router.post(
  '/update-cart/:id',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.updateCartOnPost
);
router.get(
  '/remove-cart/:id/:cid',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.removeItemCart
);
router.get(
  '/create-invoice/:id',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.createInvoice
);
router.post(
  '/create-invoice',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.createInvoiceOnPost
);
router.get(
  '/invoice/:id',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.invoice
);
router.get(
  '/cancel/:id',
  checkLogin.checkLogin,
  checkLogin.checkClient,
  fdController.cancelOrder
);

// router.get('/buy', fdController.buyOne);
// router.post('/create-invoice', fdController.createInvoiceSingle);
module.exports = router;