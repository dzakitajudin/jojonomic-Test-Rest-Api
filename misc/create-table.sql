-- table harga
CREATE TABLE IF NOT EXISTS public.tbl_harga
(
    admin_id character(50) COLLATE pg_catalog."default",
    harga_topup_emas bigint,
    harga_buyback_emas bigint
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tbl_harga
    OWNER to adminpostgre;


--table rekening
CREATE TABLE IF NOT EXISTS public.tbl_rekening
(
    norek character(50) COLLATE pg_catalog."default",
    saldo double precision
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tbl_rekening
    OWNER to adminpostgre;
	
	
-- table topup
CREATE TABLE IF NOT EXISTS public.tbl_topup
(
    norek character(50) COLLATE pg_catalog."default",
    harga_topup bigint,
    gram double precision
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tbl_topup
    OWNER to adminpostgre;
	

-- table transaksi
CREATE TABLE IF NOT EXISTS public.tbl_transaksi
(
    -- Inherited from table public.tbl_rekening: norek character(50) COLLATE pg_catalog."default",
    tanggal_awal date,
    tanggal_akhir date,
    type character(20) COLLATE pg_catalog."default",
    gram double precision,
    harga_topup bigint,
    harga_buyback bigint,
    -- Inherited from table public.tbl_rekening: saldo double precision
)
    INHERITS (public.tbl_rekening)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tbl_transaksi
    OWNER to adminpostgre;