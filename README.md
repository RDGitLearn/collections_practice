Product Catalog Service
GET /api/products: Retrieve all products.
GET /api/products/{id}: Retrieve specific product details.
GET /api/products/search?keyword=grocery: Search products by keyword.

	Product Catalog (MongoDB)
		Stores unstructured product data as JSON-like documents. 
		Collection: products
		_id: Unique Identifier (UUID)
		name: "DMart Premia Basmati Rice"
		category: "Grocery"
		description: String
		attributes: Nested object (e.g., weight: 5kg, brand: Premia)
		base_price: Decimal128


Inventory Service
GET /api/inventory/{productId}: Check total stock availability.
GET /api/inventory/store/{storeId}/{productId}: Check availability at a specific store location.
PUT /api/inventory/update: Update stock after a purchase or restock.

		Inventory Service (PostgreSQL)
			Tracks stock at specific physical store locations. 
			Table: store_inventory
			inventory_id: BigInt (PK)
			product_id: UUID (Reference to Product Service)
			store_id: Int
			available_quantity: Int
			last_updated: Timestamp
			
			
Order Service
POST /api/orders: Create a new customer order.
GET /api/orders/customer/{customerId}: Retrieve order history for a user.
GET /api/orders/{orderId}/status: Track the status of an existing order.
		Table: orders
				order_id: BigInt (PK)
				customer_id: BigInt
				total_amount: Decimal
				status: Enum (PENDING, COMPLETED, CANCELLED)
		Table: order_items
				item_id: BigInt (PK)
				order_id: BigInt (FK)
				product_id: UUID
				quantity: Int
				price_at_purchase: Decimal

Customer Service
POST /api/customers/register: Register a new user profile.
GET /api/customers/{id}: Fetch user profile and loyalty rewards.


Payment Service
POST /api/payments/process: Initiate a transaction for a specific order.
GET /api/payments/{transactionId}: Check payment status.

Table Name	Description	Key Fields
payment_transactions	Core ledger of all payment attempts.	transaction_id (PK), order_id (FK), amount, currency, status (PENDING, SUCCESS, FAILED), payment_method
payment_metadata	Stores flexible third-party gateway responses.	transaction_id (FK), gateway_name, gateway_response (JSONB), raw_payload
payment_audit_log	Immutable history of status changes for auditing.	audit_id, transaction_id, old_status, new_status, updated_at

Microservice			groupId							artifactId
ProductCatalogService	com.dmart.retail				product-service
Inventory Service		com.dmart.retail				inventory-service
Order Service			com.dmart.retail				order-service
Customer Service		com.dmart.retail				customer-service
Payment Service			com.dmart.retail				payment-service
API Gateway				com.dmart.infra					api-gateway
ServiceRegistry(Eureka)	com.dmart.infra					service-registry
Config Server			com.dmart.infra					config-server
