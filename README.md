# Aplikasi Invoice Management (Artivisi)

Aplikasi ini dipakai untuk mengelola invoice dan menyambungkan dengan berbagai metode pembayaran

Diantara metode pembayaran yang akan di support antara lain:

* Virtual Account
    * Bank BNI
    * Bank CIMB
    * Bank BSI

* e-Wallet
    * Ovo
    * Gopay

* QR Payment
    * QRIS

Tipe tagihan yang tersedia:

  * CLOSED: bayar sesuai nominal. kalau tidak sesuai, ditolak
  * OPEN: pembayaran berapapun diterima
  * INSTALLMENT: pembayaran diterima selama total akumulasi lebih kecil atau sama dengan nilai tagihan

---

## How to

### Cara Setup Database

1. Jalankan postgresql di docker

`Bash`

```shell
docker run --rm \
  --name invoice-db \
  -e POSTGRES_DB=invoicedb \
  -e POSTGRES_USER=invoice \
  -e POSTGRES_PASSWORD=hFgtQo8U8YPM9BwgK87G \
  -e PGDATA=/var/lib/postgresql/data/pgdata \
  -v "$PWD/invoicedb-data:/var/lib/postgresql/data" \
  -p 5432:5432 \
  postgres:14
```

`Powershell`

```shell
docker run --rm  `
  --name invoice-db `
  -e POSTGRES_DB=invoicedb `
  -e POSTGRES_USER=invoice `
  -e POSTGRES_PASSWORD=hFgtQo8U8YPM9BwgK87G `
  -e PGDATA=/var/lib/postgresql/data/pgdata `
  -v "$PWD/invoicedb-data:/var/lib/postgresql/data" `
  -p 5432:5432 `
  postgres:14
```

