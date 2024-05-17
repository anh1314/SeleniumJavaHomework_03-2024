package BT4_ActionsClass_RobotClass;

public class LocatorsAddProduct {
    public static String menuAddNewProduct = "//span[normalize-space()='Add New Product']";
    //Product Information
    public static String inputProductName = "//input[@placeholder='Product Name']";
    public static String dropListCategory = "//div[contains(text(),'Sport shoes')]";
    public static String searchCategory = "//div[@class='dropdown-menu show']//input[@aria-label='Search']";
    public static String dropListBrand = "//div[contains(text(),'Select Brand')]";
    public static String searchBrand = "//div[@class='dropdown-menu show']//input[@aria-label='Search']";
    public static String inputUnit = "//input[@placeholder='Unit (e.g. KG, Pc etc)']";
    public static String inputWeight = "//input[@placeholder='0.00']";
    public static String inputMinimumPurchaseQty = "//input[@name='min_qty']";
    public static String textboxTags = "//span[@role='textbox']";

    //Product Images //button[normalize-space()='Add Files']
    public static String GalleryImages  = "//div[@data-multiple='true']//div[@class='input-group-text bg-soft-secondary font-weight-medium'][normalize-space()='Browse']";
    public static String searchImages  = " //input[@placeholder='Search your files']";
    public static String linkGalleryImages   ="//img[@class='img-fit']";
    public static String buttonAddFiles = "//button[normalize-space()='Add Files']";
    public static String ThumbnailImage = "//body/div[@class='aiz-main-wrapper']/div[@class='aiz-content-wrapper']/div[@class='aiz-main-content']/div[@class='px-15px px-lg-25px']/div/form[@id='choice_form']/div[@class='row gutters-5']/div[@class='col-lg-8']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]";
    public static String linkThumbnailImage = "//div[@class='card-file-thumb']";
    //Product Videos
    public static String VideoProvider = "//button[@title='Youtube']";
    public static String VideoLink = "//input[@placeholder='Video Link']";
    //Product Variation
    public static String enableProductVariation  = "//div[@class='col-md-1']//span";
    public static String Colors = "(//button[@title='Nothing selected'])[1]";
    public static String Attributes  = "//div[@class='dropdown bootstrap-select show-tick form-control aiz- dropup show']//div[@class='filter-option-inner-inner'][normalize-space()='Nothing selected']";

   //Product price + stock
    public static String UnitPrice   = "//input[@placeholder='Unit price']";
    public static String DiscountDateRange  = "//input[@placeholder='Select Date']";
    public static String buttonSelectDate  = "//button[@class='applyBtn btn btn-sm btn-primary']";
    public static String Discount  = "//input[@placeholder='Discount']";
    public static String Flat_Percent  = "(//button[@title='Flat'])[1]";
    public static String Quantity   = "//input[@placeholder='Quantity']";
    public static String SKU  = "//input[@placeholder='SKU']";
    public static String ExternalLink  = "//input[@placeholder='External link']";
    public static String ExternalLinkButtonTex  = "//input[@placeholder='External link button text']";

    //Product Description
    public static String Description  = "//div[@role='textbox']";
    //PDF Specification
    public static String PDFSpecification  = "//div[@data-type='document']//div[@class='input-group-text bg-soft-secondary font-weight-medium'][normalize-space()='Browse']";
    //SEO Meta Tags
    public static String MetaTitle  = "//input[@placeholder='Meta Title']";
    public static String DescriptionSEO  = "//textarea[@name='meta_description']";
    public static String MetaImage  = "//div[8]//div[2]//div[3]//div[1]//div[1]//div[1]//div[1]";
    public static String linkImage = "//div[@class='card-file-thumb']";
    public static String buttonSaveUnpublish  = "//button[normalize-space()='Save & Unpublish']";
    public static String buttonSavePublish  = "//button[normalize-space()='Save & Publish']";
}
